package test.study.java.watermark.success;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * @author sun yang
 * @date 2024/11/28
 */
public class XlsxTest {

    public static void main(String[] args) throws Exception{
        ByteArrayOutputStream outputStream = addToXlsx(new FileInputStream("F:\\watermark\\success\\xlsx.xlsx"),
                new String[]{"这是xlsx水印是的发生大法师答复萨芬四大分三大发撒都发啥打法萨达发撒代发", "第二行", "第三行"},
                16,
                "#FF0000",
                100,
                45);

        outputStream.writeTo(new FileOutputStream("F:\\watermark\\success\\result\\xlsx.xlsx"));
    }

    public static ByteArrayOutputStream addToXlsx(InputStream inputStream, String[] textArr,
                                                 int fontSize, String fontColor, int opacity, int rotate) throws Exception {
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        Font font = new Font("微软雅黑", Font.PLAIN, fontSize);
        int imageSize = WatermarkUtil.calculateSize(textArr, font, rotate);
        //生成水印
        byte[] waterMarkBytes = WatermarkUtil.createSingleWaterMarkOfBytes(
                WatermarkUtil.transText(textArr),
                imageSize, imageSize,
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
