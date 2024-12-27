package test.study.java.watermark.jodconverter;

import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import test.study.java.watermark.WatermarkUtil;

import java.awt.*;
import java.io.*;

/**
 * @author sun yang
 * @date 2024/11/28
 */
public class XlsxBrightWatermark {

//    public static void main(String[] args) throws Exception{
//        ByteArrayOutputStream outputStream = addToXlsx(new FileInputStream("F:\\watermark\\libre\\xlsx.xlsx"),
//                new String[]{"这是xlsx水印", "第二行", "第三行"},
//                16,
//                "#FF0000",
//                100,
//                45);
//
//        outputStream.writeTo(new FileOutputStream("F:\\watermark\\libre\\result\\xlsx.xlsx"));
//    }

    /**
     * Add watermark to xlsx
     * @param originFilePath 原文件路径
     * @param targetPath 目标文件路径
     * @param textArr 水印文字数组，每个一行
     * @param fontSize 字体大小
     * @param fontColor 字体颜色 #FFFFFF 格式
     * @param opacity 透明度 0-100
     * @param rotate 旋转角度 0-360
     * @throws Exception
     */
    public static void addToXlsx(String originFilePath,String targetPath,String[] textArr,
                                int fontSize,String fontColor,int opacity,int rotate) throws Exception {

        File originFile = new File(originFilePath);
        ByteArrayOutputStream outputStream = addToXlsx(new FileInputStream(originFile),
                textArr,
                fontSize,
                fontColor,
                opacity,
                rotate);

        outputStream.writeTo(new FileOutputStream(targetPath + File.separator + originFile.getName()));
    }

    /**
     * Add watermark to xlsx
     * @param inputStream 原文件流
     * @param textArr 水印文字数组，每个一行
     * @param fontSize 字体大小
     * @param fontColor 字体颜色 #FFFFFF 格式
     * @param opacity 透明度 0-100
     * @param rotate 旋转角度 0-360
     * @return
     * @throws Exception
     */
    public static ByteArrayOutputStream addToXlsx(InputStream inputStream, String[] textArr,
                                                 int fontSize, String fontColor, int opacity, int rotate) throws Exception {
        ZipSecureFile.setMinInflateRatio(0.0001);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

        // 加载字体库文件
        InputStream fontStream = new FileInputStream("D:\\IDEA\\gitWork\\test4study\\study-java\\src\\main\\java\\test\\study\\java\\mianshiti2024\\simfang.ttf");
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontStream);
        font = font.deriveFont(Font.PLAIN, fontSize+10);

        int[] imageSize = WatermarkUtil.calculateSize(textArr, font, rotate);

        //生成水印
        byte[] waterMarkBytes = WatermarkUtil.createSingleWaterMarkOfBytes(
                WatermarkUtil.transText(textArr),
                imageSize[0]+50, imageSize[1]+50,
                WatermarkUtil.hexStringToColor(fontColor,opacity),
                font,
                rotate);
        int numberOfSheets = workbook.getNumberOfSheets();
        for (int i = 0; i < numberOfSheets; i++) {
            XSSFSheet sheet = workbook.getSheetAt(i);
            //插入水印
            insertWaterRemark(sheet, waterMarkBytes);
        }
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();
        return outputStream;
    }

    /**
     * 插入水印
     *
     * @param sheet sheet对象
     * @param bytes 水印图片字节数组
     */
    public static void insertWaterRemark(XSSFSheet sheet, byte[] bytes) {
        //水印图片数据关联sheet对象
        XSSFWorkbook workbook = sheet.getWorkbook();
        int pictureIdx = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
        String relationId = sheet.addRelation(null, XSSFRelation.IMAGES, workbook.getAllPictures().get(pictureIdx))
                .getRelationship().getId();
        //将水印图片设置为sheet的背景颜色
        sheet.getCTWorksheet().addNewPicture().setId(relationId);
    }

}
