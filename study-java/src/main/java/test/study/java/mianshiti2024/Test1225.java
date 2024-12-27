package test.study.java.mianshiti2024;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author sun yang
 * @date 2024/12/25
 */
public class Test1225 {

    public static int LINE_SPACE = 5;

    public static void main(String[] args) throws Exception{
        // 加载字体库文件
        InputStream fontStream = new FileInputStream("D:\\IDEA\\gitWork\\test4study\\study-java\\src\\main\\java\\test\\study\\java\\mianshiti2024\\simfang.ttf");
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontStream);
        font = font.deriveFont(Font.PLAIN, 14);

        System.out.println(calculateSize(new String[]{"13658745213", "TP-2", "sdf@adf.adf", "全部>水印组"},font,137));
    }

    public static int calculateSize(String[] lines, Font font, double rotationAngle){
        Graphics2D g2d = null;
        FontMetrics fontMetrics = null;

        // 计算最长行的宽度和所有行的高度
        int maxWidth = 0;
        int totalHeight = 0;
        for (String line : lines) {
            if (g2d == null) {
                g2d = (Graphics2D) new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB).getGraphics();
                g2d.setFont(font);
            }
            fontMetrics = g2d.getFontMetrics();
            int width = fontMetrics.stringWidth(line);
            if (width > maxWidth) {
                maxWidth = width;
            }
            totalHeight += fontMetrics.getHeight()+LINE_SPACE;
        }

        // 考虑旋转角度
        double cosAngle = Math.cos(Math.toRadians(rotationAngle));
        double sinAngle = Math.sin(Math.toRadians(rotationAngle));

        // 旋转后宽度和高度的计算需要考虑角度的影响
        int rotatedWidth = (int) (maxWidth * cosAngle + totalHeight * sinAngle);
        int rotatedHeight = (int) (maxWidth * sinAngle + totalHeight * cosAngle);

        // 确保宽度和高度为正值
        int imageWidth = Math.abs(rotatedWidth);
        int imageHeight = Math.abs(rotatedHeight);

        // 返回宽度和高度中的最大值
        return Math.max(imageWidth, imageHeight);
    }




}
