package test.study.java.watermark.jodconverter;

import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.util.Units;
import org.apache.poi.wp.usermodel.HeaderFooterType;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObject;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing;
import test.study.java.watermark.WatermarkUtil;

import java.awt.*;
import java.io.*;

/**
 * @author sun yang
 * @date 2024/11/28
 */
public class DocxBrightWatermark {

    public static void main(String[] args) throws Exception {

        ByteArrayOutputStream outputStream = addToDocx(new FileInputStream("F:\\watermark\\libre\\docx.docx"),
                new String[]{"这是docx水印", "第二行", "第三行"},
                14,
                "#FF0000",
                100,
                45);
        outputStream.writeTo(new FileOutputStream("F:\\watermark\\libre\\result\\docx.docx"));

    }

    /**
     * Add watermark to docx
     * @param originFilePath 原文件路径
     * @param targetPath 目标文件路径
     * @param textArr 水印文字数组，每个一行
     * @param fontSize 字体大小
     * @param fontColor 字体颜色 #FFFFFF 格式
     * @param opacity 透明度 0-100
     * @param rotate 旋转角度 0-360
     * @throws Exception
     */
    public static void addToDocx(String originFilePath,String targetPath,String[] textArr,
                                int fontSize,String fontColor,int opacity,int rotate) throws Exception {

        File originFile = new File(originFilePath);
        ByteArrayOutputStream outputStream = addToDocx(new FileInputStream(originFile),
                textArr,
                fontSize,
                fontColor,
                opacity,
                rotate);

        outputStream.writeTo(new FileOutputStream(targetPath + File.separator + originFile.getName()));
    }

    /**
     * Add watermark to docx
     * @param inputStream 原文件流
     * @param textArr 水印文字数组，每个一行
     * @param fontSize 字体大小
     * @param fontColor 字体颜色 #FFFFFF 格式
     * @param opacity 透明度 0-100
     * @param rotate 旋转角度 0-360
     * @return
     * @throws Exception
     */
    public static ByteArrayOutputStream addToDocx(InputStream inputStream, String[] textArr,
                                                 int fontSize,String fontColor,int opacity,int rotate) throws Exception {
        // 加载字体库文件
        InputStream fontStream = new FileInputStream("D:\\IDEA\\gitWork\\test4study\\study-java\\src\\main\\java\\test\\study\\java\\mianshiti2024\\simfang.ttf");
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontStream);
        font = font.deriveFont(Font.PLAIN, fontSize);
        int[] imageSize = WatermarkUtil.calculateSize(textArr, font, rotate);

        byte[] imageBytes = WatermarkUtil.createSingleWaterMarkOfBytes(WatermarkUtil.transText(textArr),
                imageSize[0], imageSize[1],
                WatermarkUtil.hexStringToColor(fontColor,opacity)
                ,font ,rotate);
        ZipSecureFile.setMinInflateRatio(0.001);
        XWPFDocument document = new XWPFDocument(inputStream);
        XWPFHeader header = document.createHeader(HeaderFooterType.DEFAULT); // 创建默认页眉
        XWPFParagraph paragraph = header.createParagraph();

        int gapRow = 60;
        int gapCol = 120;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                XWPFRun run = paragraph.createRun();
                try (ByteArrayInputStream is = new ByteArrayInputStream(imageBytes)) {
                    run.addPicture(is, XWPFDocument.PICTURE_TYPE_PNG, "", Units.toEMU(imageSize[0]), Units.toEMU(imageSize[1]));
                }
                CTDrawing drawing = run.getCTR().getDrawingArray(0);
                CTGraphicalObject graphicalObject = drawing.getInlineArray(0).getGraphic();
                CTAnchor anchor = getAnchorWithGraphic(graphicalObject, "",
                        Units.toEMU(imageSize[0]), Units.toEMU(imageSize[1]), // 图片的宽度和高度
                        Units.toEMU(i*(imageSize[0]+gapRow)), Units.toEMU(j*(imageSize[1]+gapCol)), false); // 指定图片的左上角坐标
                drawing.setAnchorArray(new CTAnchor[]{anchor}); // 设置图片的锚点
                drawing.removeInline(0); // 移除行内图片设置
            }
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        document.write(out);

        return out;
    }

    public static CTAnchor getAnchorWithGraphic(CTGraphicalObject ctGraphicalObject,
                                                String deskFileName, int width, int height,
                                                int leftOffset, int topOffset, boolean behind) {
        String anchorXML =
                "<wp:anchor xmlns:wp=\"http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing\" "
                        + "simplePos=\"0\" relativeHeight=\"0\" behindDoc=\"" + ((behind) ? 1 : 0) + "\" locked=\"0\" layoutInCell=\"1\" allowOverlap=\"1\">"
                        + "<wp:simplePos x=\"0\" y=\"0\"/>"
                        + "<wp:positionH relativeFrom=\"column\">"
                        + "<wp:posOffset>" + leftOffset + "</wp:posOffset>"
                        + "</wp:positionH>"
                        + "<wp:positionV relativeFrom=\"paragraph\">"
                        + "<wp:posOffset>" + topOffset + "</wp:posOffset>" +
                        "</wp:positionV>"
                        + "<wp:extent cx=\"" + width + "\" cy=\"" + height + "\"/>"
                        + "<wp:effectExtent l=\"0\" t=\"0\" r=\"0\" b=\"0\"/>"
                        + "<wp:wrapNone/>"
                        + "<wp:docPr id=\"1\" name=\"Drawing 0\" descr=\"" + deskFileName + "\"/><wp:cNvGraphicFramePr/>"
                        + "</wp:anchor>";
        try {
            CTDrawing drawing = CTDrawing.Factory.parse(anchorXML);
            CTAnchor anchor = drawing.getAnchorArray(0);
            anchor.setGraphic(ctGraphicalObject);
            return anchor;
        } catch (XmlException e) {
            e.printStackTrace();
            return null;
        }
    }

}
