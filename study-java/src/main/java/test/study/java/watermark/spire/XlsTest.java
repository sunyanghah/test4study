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
public class XlsTest {

    public static void main(String[] args) throws IOException {

        // Create a Workbook object
        Workbook workbook = new Workbook();

        // Load an Excel document
        workbook.loadFromFile("F:\\watermark\\spire\\xls.xls");

        BufferedImage image = createWaterMark("这是xls水印\n第二行\n第三行", 200, 150, new Color(255, 0, 0, 100)
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
        workbook.saveToFile("F:\\watermark\\spire\\result\\xls.xls", ExcelVersion.Version97to2003);

        // Dispose resources
        workbook.dispose();
    }

    public static BufferedImage createWaterMark(String content, int width, int height, Color color, Font font) throws IOException {
        // 获取bufferedImage对象
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        // 获取Graphics2d对象
        Graphics2D g2d = image.createGraphics();
        g2d.fillRect(0, 0, width, height);
        g2d.setComposite(AlphaComposite.SrcOver);
        // 设置字体颜色
        g2d.setColor(color);
        // 设置字体
        g2d.setFont(font);
        // 设置倾斜度
        g2d.rotate(-0.5, (double) image.getWidth() / 2, (double) image.getHeight() / 2);
        // 行间距
        int lineSpacing = 5;
        // 获取字体渲染上下文
        FontRenderContext context = g2d.getFontRenderContext();
        // 按行分割水印内容
        String[] lines = content.split("\n");
        double x = 0;
        double y = 0;

        // 绘制每一行水印
        for (String line : lines) {
            Rectangle2D bounds = font.getStringBounds(line, context);
            // 计算x和y坐标，使文字居中
            x = (width - bounds.getWidth()) / 2;
            y += bounds.getHeight() + lineSpacing; // 增加行间距
            if (y > height) break; // 如果超出图片高度，则停止绘制
            double ascent = -bounds.getY();
            double baseY = y + ascent;
            g2d.drawString(line, (int) x, (int) baseY);
        }
        // 恢复原始状态
        g2d.rotate(0.5, (double) image.getWidth() / 2, (double) image.getHeight() / 2);
        // 释放对象
        g2d.dispose();
        // 将图片写入字节流
        return image;
    }


}
