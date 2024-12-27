package test.study.java.watermark.dark;

import lombok.Data;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.poi.hpsf.CustomProperties;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hslf.usermodel.HSLFSlideShow;
import org.apache.poi.hslf.usermodel.HSLFSlideShowImpl;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.ooxml.POIXMLProperties;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.FileMagic;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFPicture;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.xmlbeans.XmlCursor;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTAbsoluteAnchor;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTOneCellAnchor;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor;
import org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import static test.study.java.watermark.dark.BusinessResponseEnum.MARK_ERROR;
import static test.study.java.watermark.dark.BusinessResponseEnum.UN_MARK_ERROR;


/**
 * 暗水印工具类
 */
public class HiddenWaterMarkUtil {

	private static Logger logger = LoggerFactory.getLogger(HiddenWaterMarkUtil.class);
	
	private static final String HIDDEN_KEY = "META_WM";

	private static final String OOXML = "OOXML";
	private static final String OLE2 = "OLE2";


	public static ByteArrayOutputStream marker(String fileName,InputStream inputStream, String hiddenMarkStr) {
		try {

			InputStream is = FileMagic.prepareToCheckMagic(inputStream);
			FileMagic fm = FileMagic.valueOf(is);

			String fileSuffix = fileName.substring(fileName.lastIndexOf(".")+1);

			if ("xls".equals(fileSuffix) || "xlsx".equals(fileSuffix)){
				if (OOXML.equals(fm.toString())){
					return markerXlsx(true,is, hiddenMarkStr,null);
				}else{
					return markerXls(true,is, hiddenMarkStr,null);
				}
			}else if ("doc".equals(fileSuffix) || "docx".equals(fileSuffix)){
				if (OOXML.equals(fm.toString())){
					return markerDocx(is, hiddenMarkStr);
				}else{
					return markerDoc(is, hiddenMarkStr);
				}
			}else if ("ppt".equals(fileSuffix) || "pptx".equals(fileSuffix)){
				if (OOXML.equals(fm.toString())){
					return markerPptx(is, hiddenMarkStr);
				}else{
					return markerPpt(is, hiddenMarkStr);
				}
			}else{
				throw UN_MARK_ERROR.newException();
			}
		} catch(Exception e) {
			e.printStackTrace();
			throw MARK_ERROR.newException();
		}
	}

	public static String parseMarker(String fileName,InputStream inputStream) {
		try {

			InputStream is = FileMagic.prepareToCheckMagic(inputStream);
			FileMagic fm = FileMagic.valueOf(is);

			String fileSuffix = fileName.substring(fileName.lastIndexOf(".")+1);

			if ("xls".equals(fileSuffix) || "xlsx".equals(fileSuffix)){
				if (OOXML.equals(fm.toString())){
					return parseMarkerXlsx(is);
				}else{
					return parseMarkerXls(is);
				}
			}else if ("doc".equals(fileSuffix) || "docx".equals(fileSuffix)){
				if (OOXML.equals(fm.toString())){
					return parseMarkerDocx(is);
				}else{
					return parseMarkerDoc(is);
				}
			}else if ("ppt".equals(fileSuffix) || "pptx".equals(fileSuffix)){
				if (OOXML.equals(fm.toString())){
					return parseMarkerPptx(is);
				}else{
					return parseMarkerPpt(is);
				}
			}else{
				throw UN_MARK_ERROR.newException();
			}
		} catch(Exception e) {
			e.printStackTrace();
			throw UN_MARK_ERROR.newException();
		}
	}

	//图片暗水印方式
	public final static class IMG_TYPE {
		public final static int DCT = 1;//DCT
    	public final static int DFT = 2;//DFT
	}

	@Data
	public static class RowCellParam {

		private Integer row;

		private Integer cell;
	}

	/**
     * excel .xls .et 操作修改
     * @param type true加暗水印false不加暗水印
     * @param inputStream
     * @param hiddenMarkStr 暗水印
     * @param map Map<页码, 列数,行数>
     * @return ByteArrayOutputStream
     */
    public static ByteArrayOutputStream markerXls(boolean type, InputStream inputStream, String hiddenMarkStr, Map<Integer, RowCellParam> map) {
		try {
			hiddenMarkStr = AESUtil.Encrypt(hiddenMarkStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ByteArrayOutputStream resOs = new ByteArrayOutputStream();
    	try (POIFSFileSystem pfs = new POIFSFileSystem(inputStream);
    			HSSFWorkbook hssfWorkbook = new HSSFWorkbook(pfs)) {
    		if(type == true) { //加暗水印
    			DocumentSummaryInformation documentSummaryInformation = hssfWorkbook.getDocumentSummaryInformation();
				if(documentSummaryInformation==null){
					hssfWorkbook.createInformationProperties();
					documentSummaryInformation = hssfWorkbook.getDocumentSummaryInformation();
				}
                CustomProperties customProperties = documentSummaryInformation.getCustomProperties();
                if (customProperties == null) {
                    customProperties = new CustomProperties();
                }
                customProperties.put(HIDDEN_KEY, hiddenMarkStr);
                documentSummaryInformation.setCustomProperties(customProperties);
                //图片加注
//            	markerImgHSSF(hssfWorkbook, hiddenMarkStr);
    		}
    		//获取行列坐标,取空表格
    		getLastRowCell(map, hssfWorkbook, null);
    		if(type == true) { //加暗水印
    			//hssfWorkbook.writeProperties(pfs);//只操作属性
    			hssfWorkbook.write(resOs);
    		} else {
    			pfs.writeFilesystem(resOs);
    		}
    		return resOs;
    	} catch(Exception e) {
    		e.printStackTrace();
    		throw MARK_ERROR.newException();
    	}
    }

    /**
     * excel .xlsx 操作修改
     * @param type true加暗水印false不加暗水印
     * @param inputStream
     * @param hiddenMarkStr 暗水印
     * @param map Map<页码, 列数,行数>
     * @return ByteArrayOutputStream
     */
    public static ByteArrayOutputStream markerXlsx(boolean type, InputStream inputStream, String hiddenMarkStr, Map<Integer, RowCellParam> map) {
		try {
			hiddenMarkStr = AESUtil.Encrypt(hiddenMarkStr);
		} catch (Exception e) {
			e.printStackTrace();
		}

    	ByteArrayOutputStream resOs = new ByteArrayOutputStream();
		OPCPackage o = null;
		try {
			if(type == true) { //加暗水印
				o = OPCPackage.open(inputStream);
				POIXMLProperties p = new POIXMLProperties(o);
				POIXMLProperties.CustomProperties customProperties = p.getCustomProperties();
				//存在已有水印,没有put方法
            	checkProperties(customProperties, HIDDEN_KEY);
				customProperties.addProperty(HIDDEN_KEY, hiddenMarkStr);
				p.commit();
				o.save(resOs);
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw MARK_ERROR.newException();
        }finally {
			if(o!=null){
				try{
					o.close();
				}catch (IOException ex){
					logger.error("poiutil异常：",ex);
					//throw new InjectException(InjectStatusEnum.SECRET_INJECT_ERROR, ex);
				}

			}
		}
		return resOs;
    }

    /**
     * word .doc .wps 操作修改
     * @param inputStream
     * @param hiddenMarkStr 暗水印
     * @return ByteArrayOutputStream
     */
    public static ByteArrayOutputStream markerDoc(InputStream inputStream, String hiddenMarkStr) {
		logger.info("开始添加水印...");

		try {
			hiddenMarkStr = AESUtil.Encrypt(hiddenMarkStr);
		} catch (Exception e) {
			e.printStackTrace();
		}

    	ByteArrayOutputStream resOs = new ByteArrayOutputStream();
    	try (POIFSFileSystem pfs = new POIFSFileSystem(inputStream);
    			HWPFDocument hwpfDocument = new HWPFDocument(pfs);){
    		DocumentSummaryInformation documentSummaryInformation = hwpfDocument.getDocumentSummaryInformation();
            CustomProperties customProperties = documentSummaryInformation.getCustomProperties();
            if (null == customProperties) {
                customProperties = new CustomProperties();
            }
            customProperties.put(HIDDEN_KEY, hiddenMarkStr);
            documentSummaryInformation.setCustomProperties(customProperties);
            hwpfDocument.writeProperties(pfs);
            pfs.writeFilesystem(resOs);
            return resOs;
    	} catch (Exception ex) {
			logger.error("word文件添加水印错误", ex);
			throw MARK_ERROR.newException();
        }
    }

    /**
     * word .docx 操作修改
     * @param inputStream
     * @param hiddenMarkStr 暗水印
     * @return ByteArrayOutputStream
     */
    public static ByteArrayOutputStream markerDocx(InputStream inputStream, String hiddenMarkStr) {

		try {
			hiddenMarkStr = AESUtil.Encrypt(hiddenMarkStr);
		} catch (Exception e) {
			e.printStackTrace();
		}

    	ByteArrayOutputStream resOs = new ByteArrayOutputStream();
    	try (XWPFDocument xwpfDoc = new XWPFDocument(inputStream)) {
    		POIXMLProperties.CustomProperties cust = xwpfDoc.getProperties().getCustomProperties();
    		//存在已有水印,没有put方法
    		checkProperties(cust, HIDDEN_KEY);
    		cust.addProperty(HIDDEN_KEY, hiddenMarkStr);
    		//图片加注
//        	markerImgXWPF(xwpfDoc, hiddenMarkStr);
            xwpfDoc.write(resOs);
            return resOs;
        } catch (Exception ex) {
			ex.printStackTrace();
            // 暗水印提取失败
			throw MARK_ERROR.newException();
        }
    }

    /**
     * ppt .ppt .dps 操作修改
     * @param inputStream
     * @param hiddenMarkStr 暗水印
     * @return ByteArrayOutputStream
     */
    public static ByteArrayOutputStream markerPpt(InputStream inputStream, String hiddenMarkStr) {

		try {
			hiddenMarkStr = AESUtil.Encrypt(hiddenMarkStr);
		} catch (Exception e) {
			e.printStackTrace();
		}

    	ByteArrayOutputStream resOs = new ByteArrayOutputStream();
    	try (POIFSFileSystem pfs = new POIFSFileSystem(inputStream);
    			HSLFSlideShow hslf = new HSLFSlideShow(pfs);) {
    		DocumentSummaryInformation documentSummaryInformation = hslf.getDocumentSummaryInformation();
            CustomProperties customProperties = documentSummaryInformation.getCustomProperties();
            if (customProperties == null) {
                customProperties = new CustomProperties();
            }
            customProperties.put(HIDDEN_KEY, hiddenMarkStr);
            documentSummaryInformation.setCustomProperties(customProperties);
            //图片加注
//        	markerImgHSLF(hslf, hiddenMarkStr);
            hslf.write(resOs);
            //pfs.writeFilesystem(resOs);
            return resOs;
    	} catch(Exception e) {
    		e.printStackTrace();
			throw MARK_ERROR.newException();
    	}
    }

    /**
     * ppt pptx 操作修改
     * @param inputStream
     * @param hiddenMarkStr 暗水印
     * @return ByteArrayOutputStream
     */
    public static ByteArrayOutputStream markerPptx(InputStream inputStream, String hiddenMarkStr) {

		try {
			hiddenMarkStr = AESUtil.Encrypt(hiddenMarkStr);
		} catch (Exception e) {
			e.printStackTrace();
		}

    	ByteArrayOutputStream resOs = new ByteArrayOutputStream();
    	try (XMLSlideShow xslfDoc = new XMLSlideShow(inputStream)) {
    		POIXMLProperties.CustomProperties cust = xslfDoc.getProperties().getCustomProperties();
    		//存在已有水印,没有put方法
    		checkProperties(cust, HIDDEN_KEY);
    		cust.addProperty(HIDDEN_KEY, hiddenMarkStr);
    		//图片加注
//        	markerImgXSLF(xslfDoc, hiddenMarkStr);
    		xslfDoc.write(resOs);
            return resOs;
        } catch (Exception ex) {
			ex.printStackTrace();
            // 暗水印提取失败
			throw MARK_ERROR.newException();
        }
    }

	/**
	 * pdf 操作修改
	 * @param inputStream
	 * @param hiddenMarkStr
	 * @return
	 */
	public static ByteArrayOutputStream markerPdf(InputStream inputStream, String hiddenMarkStr){
		try {
			hiddenMarkStr = AESUtil.Encrypt(hiddenMarkStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ByteArrayOutputStream resOs = new ByteArrayOutputStream();
		try (PDDocument document = PDDocument.load(inputStream)) {
			PDDocumentInformation info = document.getDocumentInformation();
			info.setCustomMetadataValue(HIDDEN_KEY, hiddenMarkStr);
			document.save(resOs);
			return resOs;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw MARK_ERROR.newException();
		}
	}

    /**
     * excel .xls .et 文件溯源, 接收文件流
     *
     * @param parseStream 溯源文件的流对象
     * @return java.lang.String 返回溯源结果
     * @date 2020/1/21 11:16
     */
    public static String parseMarkerXls(InputStream parseStream) {
        // 初始化溯源结果
        String wmImplicit = null;
        try (HSSFWorkbook hssfDoc = new HSSFWorkbook(parseStream)) {
            // 提取Excel中的暗水印
            DocumentSummaryInformation documentSummaryInformation = hssfDoc.getDocumentSummaryInformation();
            CustomProperties customProperties = documentSummaryInformation.getCustomProperties();
            if(customProperties.get(HIDDEN_KEY) != null) {
            	wmImplicit = String.valueOf(customProperties.get(HIDDEN_KEY));
            }
        } catch (Exception ex) {
			ex.printStackTrace();
			throw UN_MARK_ERROR.newException();
        }
		try {
			return wmImplicit == null ? null : AESUtil.Decrypt(wmImplicit);
		} catch (Exception e) {
			return wmImplicit;
		}
	}

    /**
     * excel .xlsx 文件溯源, 接收文件流
     *
     * @param parseStream 溯源文件的流对象
     * @return java.lang.String 返回溯源结果
     * @date 2020/1/21 11:16
     */
    public static String parseMarkerXlsx(InputStream parseStream) {
        // 初始化溯源结果
    	String wmImplicit = null;
		OPCPackage o = null;
		try{
			o = OPCPackage.open(parseStream);
			POIXMLProperties p = new POIXMLProperties(o);
			POIXMLProperties.CustomProperties customProperties= p.getCustomProperties();
			if(customProperties !=null){
				CTProperty ctProperty = customProperties.getProperty(HIDDEN_KEY);
				wmImplicit = ctProperty != null ? ctProperty.getLpwstr() : wmImplicit;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw UN_MARK_ERROR.newException();
        } finally {
			if(o!=null){
				try{
					o.close();
				}catch (IOException ex){
					logger.error("poiutil出现异常：",ex);
				}

			}
		}
		try {
			return wmImplicit == null ? null : AESUtil.Decrypt(wmImplicit);
		} catch (Exception e) {
			return wmImplicit;
		}
    }

    /**
     * word .doc .wps 文件溯源
     *
     * @param parseStream 溯源文件的流对象
     * @return java.lang.String 返回溯源信息
     * @date 2020/1/21 09:39
     */
    public static String parseMarkerDoc(InputStream parseStream) {
    	// 初始化暗水印文本
        String wmImplicit = null;
        // 提取HWPF文件暗水印
        try (HWPFDocument hwpfDoc = new HWPFDocument(parseStream)){
        	DocumentSummaryInformation documentSummaryInformation = hwpfDoc.getDocumentSummaryInformation();
            CustomProperties customProperties = documentSummaryInformation.getCustomProperties();
            if(customProperties != null && customProperties.get(HIDDEN_KEY) != null) {
            	wmImplicit = (String) customProperties.get(HIDDEN_KEY);
            }
        } catch (Exception ex) {
			ex.printStackTrace();
            // 暗水印提取失败
			throw UN_MARK_ERROR.newException();
        }
		try {
			return wmImplicit == null ? null : AESUtil.Decrypt(wmImplicit);
		} catch (Exception e) {
			return wmImplicit;
		}
    }

    /**
     * word .docx 文件溯源
     *
     * @param parseStream 溯源文件的流对象
     * @return java.lang.String 返回溯源信息
     * @date 2020/1/21 09:39
     */
    public static String parseMarkerDocx(InputStream parseStream) {
    	// 初始化暗水印文本
        String wmImplicit = null;
        // 提取XWPF文件暗水印
        try (XWPFDocument xwpfDoc = new XWPFDocument(parseStream)) {
            POIXMLProperties.CustomProperties cust = xwpfDoc.getProperties().getCustomProperties();
            if(cust != null) {
            	CTProperty ctProperty = cust.getProperty(HIDDEN_KEY);
                wmImplicit = ctProperty != null ? ctProperty.getLpwstr() : wmImplicit;
            }
        } catch (Exception ex) {
			ex.printStackTrace();
            // 暗水印提取失败
			throw UN_MARK_ERROR.newException();
        }
		try {
			return wmImplicit == null ? null : AESUtil.Decrypt(wmImplicit);
		} catch (Exception e) {
			return wmImplicit;
		}
    }

    /**
     * ppt .ppt .dps 文件溯源
     *
     * @param parseStream 溯源文件的流对象
     * @return java.lang.String 返回溯源信息
     * @date 2021/1/25 09:39
     */
    public static String parseMarkerPpt(InputStream parseStream) {
        String wmImplicit = null;
        try (HSLFSlideShowImpl hslfDoc = new HSLFSlideShowImpl(parseStream)){
        	DocumentSummaryInformation documentSummaryInformation = hslfDoc.getDocumentSummaryInformation();
            CustomProperties customProperties = documentSummaryInformation.getCustomProperties();
            if(customProperties != null && customProperties.get(HIDDEN_KEY) != null) {
            	wmImplicit = (String) customProperties.get(HIDDEN_KEY);
            }
        } catch (Exception ex) {
			ex.printStackTrace();
            // 暗水印提取失败
			throw UN_MARK_ERROR.newException();
        }
		try {
			return wmImplicit == null ? null : AESUtil.Decrypt(wmImplicit);
		} catch (Exception e) {
			return wmImplicit;
		}
    }

    /**
     * ppt .pptx 文件溯源
     *
     * @param parseStream 溯源文件的流对象
     * @return java.lang.String 返回溯源信息
     * @date 2021/1/25 09:39
     */
    public static String parseMarkerPptx(InputStream parseStream) {
        String wmImplicit = null;
        try (XMLSlideShow xslfDoc = new XMLSlideShow(parseStream)){
        	POIXMLProperties.CustomProperties cust = xslfDoc.getProperties().getCustomProperties();
            if(cust != null) {
            	CTProperty ctProperty = cust.getProperty(HIDDEN_KEY);
                wmImplicit = ctProperty != null ? ctProperty.getLpwstr() : wmImplicit;
            }
        } catch (Exception ex) {
			ex.printStackTrace();
            // 暗水印提取失败
			throw UN_MARK_ERROR.newException();
        }
		try {
			return wmImplicit == null ? null : AESUtil.Decrypt(wmImplicit);
		} catch (Exception e) {
			return wmImplicit;
		}
    }

	/**
	 * pdf 文件溯源
	 * @param parseStream
	 * @return
	 */
	public static String parseMarkerPdf(InputStream parseStream){
		try(PDDocument document = PDDocument.load(parseStream)){
			PDDocumentInformation info = document.getDocumentInformation();
			String customMetadataValue = info.getCustomMetadataValue(HIDDEN_KEY);
			return AESUtil.Decrypt(customMetadataValue);
		}catch (Exception ex){
			throw UN_MARK_ERROR.newException();
		}

	}

    /**
     * excel获取每页最后数据栏
     * @param hssfWorkbook
     * @param xssfWorkbook
     * @return Map<页码, 列数,行数>
     */
    private static void getLastRowCell(Map<Integer, RowCellParam> map, HSSFWorkbook hssfWorkbook, XSSFWorkbook xssfWorkbook) {
    	//获取行列坐标,取空表格
    	if(map == null) {
    		return;
    	}
    	if(xssfWorkbook == null) {
    		for(int i = 0 ; i < hssfWorkbook.getNumberOfSheets(); i ++) {
            	HSSFSheet sheet = hssfWorkbook.getSheetAt(i);
    			if(sheet != null) {
    				Integer lastRow = sheet.getLastRowNum();
    				//System.out.println("Row:" + i + ",lastRow:" + lastRow);
    				if(lastRow > -1) {
    					Integer lastCell = -1;
        				for(int j = 0 ; j <= lastRow ; j ++) {
        					if(sheet.getRow(j) != null) {
        						short last = sheet.getRow(j).getLastCellNum();
        						lastCell = lastCell < last ? last : lastCell;
        						//System.out.println("Row:" + i + ",old:" + lastCell + ",new:" + last);
        					}
        				}
        				if(lastCell > -1) {
        					RowCellParam rowCellParam = new RowCellParam();
        					rowCellParam.setCell(lastCell);
        					rowCellParam.setRow(lastRow);
        					map.put(i, rowCellParam);
        				}
        			}
    			}
    		}
    	} else {
    		for(int i = 0 ; i < xssfWorkbook.getNumberOfSheets(); i ++) {
            	XSSFSheet sheet = xssfWorkbook.getSheetAt(i);
    			if(sheet != null) {
    				Integer lastRow = sheet.getLastRowNum();
    				//System.out.println("Row:" + i + ",lastRow:" + lastRow);
    				if(lastRow > -1) {
    					Integer lastCell = -1;
        				for(int j = 0 ; j <= lastRow ; j ++) {
        					if(sheet.getRow(j) != null) {
        						short last = sheet.getRow(j).getLastCellNum();
        						lastCell = lastCell < last ? last : lastCell;
        						//System.out.println("Row:" + i + ",old:" + lastCell + ",new:" + last);
        					}
        				}
        				if(lastCell > -1) {
        					RowCellParam rowCellParam = new RowCellParam();
        					rowCellParam.setCell(lastCell);
        					rowCellParam.setRow(lastRow);
        					map.put(i, rowCellParam);
        				}
        			}
    			}
    		}
    	}
    }

    /**
     * 检验是否已存在属性
     * @param cust
     * @param key 属性名
     */
    private static void checkProperties(POIXMLProperties.CustomProperties cust, String key) {
    	//存在已有水印,没有put方法
    	if(cust != null && cust.contains(key)) {
    		List<CTProperty> list = cust.getUnderlyingProperties().getPropertyList();
    		for(int i = 0 ; i < list.size() ; i ++) {
    			if((list.get(i).getName()).equals(key)) {
    				list.remove(i);//删除掉
    				break;
    			}
    		}
    	}
    }

    /**
     * excel xlsx 附件图片暗水印加注
     * @param xssfWorkbook
     * @param hiddenMarkStr 暗水印
     */
//    private static void markerImgXSSF(XSSFWorkbook xssfWorkbook, String hiddenMarkStr) {
////    	if(ANNEX_TYPE.EXCEL.IMG != MARK_TYPE.YES) {
////    		return ;
////    	}
//    	int num = xssfWorkbook.getNumberOfSheets();
//    	for(int i = 0 ; i < num ; i ++) {
//    		XSSFSheet sheet = xssfWorkbook.getSheetAt(i);
//    		XSSFDrawing drawing = sheet.getDrawingPatriarch();
//    		if(drawing != null) {
//    			List<XSSFShape> list = drawing.getShapes();
//    			for(XSSFShape shape : list) {
//    				if (shape instanceof XSSFObjectData) {
//    					continue;//过滤文件
//    				}
//					if (shape instanceof XSSFPicture) {
//						XSSFPicture pic = (XSSFPicture) shape;
//						XSSFClientAnchor anchor = pic.getPreferredSize();
//						XSSFClientAnchor anchorNew = new XSSFClientAnchor(anchor.getDx1(),  anchor.getDy1(),  anchor.getDx2(),  anchor.getDy2(),
//								anchor.getCol1(),  anchor.getRow1(), anchor.getCol2(),  anchor.getRow2());//位置  后四个参数:   前两个: 图片左上角的X,Y坐标     后两个:图片右下左上角的X,Y坐标
//						anchorNew.setAnchorType(anchor.getAnchorType());
//						ByteArrayOutputStream os = markerImg(IMG_TYPE.DCT, pic.getPictureData().getData(), hiddenMarkStr);//图片加注
//						drawing.createPicture(anchorNew, xssfWorkbook.addPicture(os.toByteArray(), pic.getPictureData().getPictureType()));//执行
//						deleteXSSFPicture(pic);//删除
//                    }
//				}
//    		}
//    	}
//    }

    /**
     * excel xls 附件图片暗水印加注
     * @param hssfWorkbook
     * @param hiddenMarkStr 暗水印
     */
//    private static void markerImgHSSF(HSSFWorkbook hssfWorkbook, String hiddenMarkStr) throws Exception {
////    	if(ANNEX_TYPE.EXCEL.IMG != MARK_TYPE.YES) {
////    		return ;
////    	}
//    	int num = hssfWorkbook.getNumberOfSheets();
//    	for(int i = 0 ; i < num ; i ++) {
//    		HSSFSheet sheet = hssfWorkbook.getSheetAt(i);
//    		HSSFPatriarch patriarch = sheet.getDrawingPatriarch();
//    		if(patriarch != null) {
//    			List<HSSFShape> listShape = patriarch.getChildren();
//    			int size = listShape.size();
//    			int addNum = 0;
//    			for (int j = 0 ; j < size ; j ++) {
//    				HSSFShape shape = listShape.get(j);
//    				if (shape instanceof HSSFObjectData) {
//						continue;
//    				}
//    				if (shape instanceof HSSFPicture) {
//						HSSFPicture pic = (HSSFPicture) shape;
//						//System.out.println(i + "  " + pic.getPictureData().getPictureType());
//						HSSFClientAnchor anchor = pic.getPreferredSize();
//						HSSFClientAnchor anchorNew = new HSSFClientAnchor(anchor.getDx1(),  anchor.getDy1(),  anchor.getDx2(),  anchor.getDy2(),
//								anchor.getCol1(),  anchor.getRow1(), anchor.getCol2(),  anchor.getRow2());//位置  后四个参数:   前两个: 图片左上角的X,Y坐标     后两个:图片右下左上角的X,Y坐标
//						anchorNew.setAnchorType(anchor.getAnchorType());
//						ByteArrayOutputStream os = markerImg(IMG_TYPE.DCT, pic.getPictureData().getData(), hiddenMarkStr);//图片加注
//						patriarch.createPicture(anchorNew, hssfWorkbook.addPicture(os.toByteArray(), pic.getPictureData().getPictureType()));//执行
//						addNum ++;
//					}
//				}
//    			for (int j = 0 ; j < addNum ; j ++) {
//    				int index = 0;
//    				while(true) {
//    					HSSFShape shape = patriarch.getChildren().get(index);
//    					if (shape instanceof HSSFObjectData) {
//    						index ++;
//    						continue;
//        				}
//    					if (shape instanceof HSSFPicture) {
//        					patriarch.removeShape(shape);//删除旧的图片
//        					break;
//        				}
//        				index ++;
//    				}
//    			}
//    		}
//    	}
//    }

    /**
     * word docx 附件图片暗水印加注
     * @param doc
     * @param hiddenMarkStr 暗水印
     */
//    private static void markerImgXWPF(XWPFDocument doc, String hiddenMarkStr) throws Exception {
////    	if(ANNEX_TYPE.WORD.IMG != MARK_TYPE.YES) {
////    		return ;
////    	}
//    	List<XWPFParagraph> listPar = doc.getParagraphs();
//    	for(int i = 0 ; i < listPar.size() ; i ++) {
//    		XWPFParagraph par = listPar.get(i);
//			List<XWPFRun> runList = par.getRuns();
//			List<Integer> listIndex = new ArrayList<Integer>();//需要删除的旧图片索引
//			int runNum = runList.size();//死循环
//			for(int j = 0 ; j < runNum ; j ++) {
//				XWPFRun run = runList.get(j);
//				List<XWPFPicture> listPic = run.getEmbeddedPictures();
//				if(listPic != null && listPic.size() > 0) {
//					listIndex.add(j);
//					int size = listPic.size();
//					XWPFRun runNew = par.createRun();
//					for(int k = 0 ; k < size ; k ++) {
//						XWPFPictureData pic = listPic.get(k).getPictureData();
//						ByteArrayOutputStream os = markerImg(IMG_TYPE.DCT, pic.getData(), hiddenMarkStr);//图片加注
//						runNew.addPicture(new ByteArrayInputStream(os.toByteArray()), pic.getPictureType(), pic.getFileName(),
//								Units.toEMU(listPic.get(k).getWidth()), Units.toEMU(listPic.get(k).getDepth()));
//					}
//				}
//			}
//			if(listIndex.size() > 0) { //删除原有
//				for(int j = 0 ; j < listIndex.size() ; j ++) {
//					par.removeRun(listIndex.get(j));
//				}
//			}
//    	}
//    }

    /**
     * pptx 附件图片暗水印加注
     * @param doc
     * @param hiddenMarkStr 暗水印
     */
//    private static void markerImgXSLF(XMLSlideShow doc, String hiddenMarkStr) throws Exception {
////    	if(ANNEX_TYPE.PPT.IMG != MARK_TYPE.YES) {
////    		return ;
////    	}
//    	List<XSLFSlide> listSlide = doc.getSlides();//过滤背景图
//    	for(int i = 0 ; i < listSlide.size() ; i ++) {
//			XSLFSlide slide = listSlide.get(i);
//			List<XSLFShape> listShape = slide.getShapes();
//			for(int j = 0 ; j < listShape.size() ; j ++) {
//				XSLFShape shape = listShape.get(j);
//				if(shape instanceof XSLFPictureShape) {
//					XSLFPictureShape pic = (XSLFPictureShape) shape;
//					ByteArrayOutputStream os = markerImg(IMG_TYPE.DCT, pic.getPictureData().getData(), hiddenMarkStr);//图片加注
//					pic.getPictureData().setData(os.toByteArray());
//					pic.getAnchor();
//				}
//			}
//		}
//    }

    /**
     * ppt dps 附件图片暗水印加注
     * @param doc
     * @param hiddenMarkStr 暗水印
     */
//    private static void markerImgHSLF(HSLFSlideShow doc, String hiddenMarkStr) throws Exception {
////    	if(ANNEX_TYPE.PPT.IMG != MARK_TYPE.YES) {
////    		return ;
////    	}
//    	List<HSLFSlide> listSlide = doc.getSlides();//过滤背景图
//
//    	for(int i = 0 ; i < listSlide.size() ; i ++) {
//			HSLFSlide slide = listSlide.get(i);
//			//slide
//			//slide
//			List<HSLFShape> listShape = slide.getShapes();
//			for(int j = 0 ; j < listShape.size() ; j ++) {
//				//System.out.println("in:" + slide.getSlideLayout());
//				HSLFShape shape = listShape.get(j);
//				if(shape instanceof HSLFPictureShape) {
//					HSLFPictureShape picShape = (HSLFPictureShape) shape;
//					HSLFPictureData picData = picShape.getPictureData();
//					ByteArrayOutputStream os = markerImg(IMG_TYPE.DCT, picData.getData(), hiddenMarkStr);//图片加注
//					//picData.setData(os.toByteArray());//会出现图片一半
//					Rectangle2D rectangle2D = picShape.getAnchor();
//					if(rectangle2D.getX() < 0 || rectangle2D.getY() < 0
//							|| rectangle2D.getWidth() < 0 || rectangle2D.getHeight() < 0) {
//						continue;//图片超出边界，坐标有问题
//					}
//					HSLFPictureData pdNew = doc.addPicture(os.toByteArray(), picData.getType());
//					HSLFPictureShape picShapeNew = new HSLFPictureShape(pdNew);
//					//Rectangle2D rect = setRectangle2D(doc, picShape);
//					System.out.println("xy:" + rectangle2D);
//					picShapeNew.setAnchor(rectangle2D);
//					picShapeNew.setShapeType(picShape.getShapeType());
//					slide.addShape(picShapeNew);
//					slide.removeShape(shape);
//				}
//			}
//		}
//    }

    /**
     * 删除
     * @param xssfPicture
     */
    public static void deleteXSSFPicture(XSSFPicture xssfPicture) {
    	String rId = xssfPicture.getCTPicture().getBlipFill().getBlip().getEmbed();
		XSSFDrawing drawing = xssfPicture.getDrawing();
		drawing.getPackagePart().removeRelationship(rId);
		drawing.getPackagePart().getPackage().deletePartRecursive(drawing.getRelationById(rId).getPackagePart().getPartName());
		XmlCursor cursor = xssfPicture.getCTPicture().newCursor();
        cursor.toParent();
        if (cursor.getObject() instanceof CTTwoCellAnchor) {
			for (int i = 0; i < drawing.getCTDrawing().getTwoCellAnchorList().size(); i++) {
				if (cursor.getObject().equals(drawing.getCTDrawing().getTwoCellAnchorArray(i))) {
					drawing.getCTDrawing().removeTwoCellAnchor(i);
                }
            }
        } else if (cursor.getObject() instanceof CTOneCellAnchor) {
			for (int i = 0; i < drawing.getCTDrawing().getOneCellAnchorList().size(); i++) {
				if (cursor.getObject().equals(drawing.getCTDrawing().getOneCellAnchorArray(i))) {
					drawing.getCTDrawing().removeOneCellAnchor(i);
                }
			}
		} else if (cursor.getObject() instanceof CTAbsoluteAnchor) {
			for (int i = 0; i < drawing.getCTDrawing().getAbsoluteAnchorList().size(); i++) {
				if (cursor.getObject().equals(drawing.getCTDrawing().getAbsoluteAnchorArray(i))) {
					drawing.getCTDrawing().removeAbsoluteAnchor(i);
				}
            }
		}
    }

    /**
     * 图片加注暗水印方式
     * @param type 1:DCT 2 DFT
     * @param data 图片内容
     * @param hiddenMarkStr 暗水印
     * @return
     */
//    public static ByteArrayOutputStream markerImg(int type, byte[] data, String hiddenMarkStr) {
//    	InputStream inImg = new ByteArrayInputStream(data);
//    	String markStr = AnalysisUtil.base64Key(2, hiddenMarkStr);//转换明文
//    	ByteArrayOutputStream os = null;
//		if(type == IMG_TYPE.DCT) {
//			WatermarkImg_DCT img = new WatermarkImg_DCT();
//			os = img.injectMarker(inImg, null, null, null, markStr);
//    	} else {
//    		WatermarkImg_DFT img = new WatermarkImg_DFT();
//    		os = img.injectMarker(inImg, null, null, null, markStr);
//    	}
//    	return os;
//		return null;
//    }


}
