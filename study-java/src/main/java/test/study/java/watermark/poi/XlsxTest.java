package test.study.java.watermark.poi;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * @author sun yang
 * @date 2024/11/27
 */
public class XlsxTest {

    public static void main(String[] args) {
        handleXlsx();
    }

    public static void handleXlsx(){
        try {
            File file = new File("F:\\watermark\\xlsx2.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file));
            //生成水印
            byte[] waterMarkBytes = createWaterMark("我尼玛水印", 200, 150, new Color(255, 0, 0, 100)
                    , new Font("微软雅黑", Font.BOLD, 20));
            int numberOfSheets = workbook.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++) {
                XSSFSheet sheet = workbook.getSheetAt(i);
                //插入水印
                insertWaterRemark(sheet, waterMarkBytes);
            }
            workbook.write(new FileOutputStream(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成水印
     *
     * @param content 水印内容
     * @param width   宽度
     * @param height  高度
     * @param color   字体颜色
     * @param font    字体信息
     * @return
     * @throws IOException
     */
    public static byte[] createWaterMark(String content, int width, int height, java.awt.Color color, java.awt.Font font) throws IOException {
        // 获取bufferedImage对象
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // 获取Graphics2d对象
        Graphics2D g2d = image.createGraphics();
        image = g2d.getDeviceConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT);
        g2d.dispose();
        g2d = image.createGraphics();
        //设置字体颜色
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(1));
        // 设置字体
        g2d.setFont(font);
        //设置倾斜度
        g2d.rotate(-0.5, (double) image.getWidth() / 2, (double) image.getHeight() / 2);
        FontRenderContext context = g2d.getFontRenderContext();
        Rectangle2D bounds = font.getStringBounds(content, context);
        double x = (width - bounds.getWidth()) / 2;
        double y = (height - bounds.getHeight()) / 2;
        double ascent = -bounds.getY();
        double baseY = y + ascent;
        // 写入水印文字原定高度过小，所以累计写水印，增加高度
        g2d.drawString(content, (int) x, (int) baseY);
        // 设置透明度
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
        // 释放对象
        g2d.dispose();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageIO.write(image, "png", os);
        return os.toByteArray();
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
