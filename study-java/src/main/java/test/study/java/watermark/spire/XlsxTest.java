package test.study.java.watermark.spire;

import com.spire.xls.ExcelVersion;
import com.spire.xls.Workbook;
import com.spire.xls.Worksheet;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author sun yang
 * @date 2024/11/28
 */
public class XlsxTest {

    public static void main(String[] args) throws IOException {

        // Create a Workbook object
        Workbook workbook = new Workbook();

        // Load an Excel document
        workbook.loadFromFile("F:\\watermark\\spire\\xlsx.xlsx");

        BufferedImage image = createWaterMark("这是xlsx水印", 200, 150, new Color(255, 0, 0, 100)
                , new Font("微软雅黑", Font.BOLD, 20));

        // Loop through all worksheets in the file
        for (int i = 0; i < workbook.getWorksheets().getCount(); i++)
        {
            // Get a specific worksheet
            Worksheet worksheet = workbook.getWorksheets().get(i);

            // Set the image as the background of the worksheet
            worksheet.getPageSetup().setBackgoundImage(image);
        }

        // Save the result file
        workbook.saveToFile("F:\\watermark\\spire\\result\\xlsx.xlsx", ExcelVersion.Version2016);

        // Dispose resources
        workbook.dispose();
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
    public static BufferedImage createWaterMark(String content, int width, int height, java.awt.Color color, java.awt.Font font) throws IOException {
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
        return image;
    }


}
