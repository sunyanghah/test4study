package test.study.java.watermark;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * @author sun yang
 * @date 2024/12/2
 */
public class WatermarkUtil {

    public static int LINE_SPACE = 5;

    /**
     * 将十六进制颜色字符串转换为java.awt.Color对象。
     *
     * @param fontColor 十六进制颜色字符串（以"#"开头）
     * @param opacity  颜色的不透明度（0-255）
     * @return 对应的java.awt.Color对象
     */
    public static Color hexStringToColor(String fontColor,int opacity) {
        if (fontColor == null || !fontColor.startsWith("#")) {
            throw new IllegalArgumentException("Invalid hex color: " + fontColor);
        }
        int rgba;
        try {
            // Remove the '#' character from the hex string
            String hexColor = fontColor.substring(1);

            // Parse the hex color to int values for RGB
            int r = Integer.parseInt(hexColor.substring(0, 2), 16);
            int g = Integer.parseInt(hexColor.substring(2, 4), 16);
            int b = Integer.parseInt(hexColor.substring(4, 6), 16);

            // Create a new Color object with the RGB values and opacity
            return new Color(r, g, b, opacity);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid hex color format: " + fontColor, e);
        }
    }

    /**
     * 将文本数组转换为水印字符串
     * @param texts
     * @return
     */
    public static String transText(String[] texts) {
        if (texts == null || texts.length == 0) {
            return "";
        }
        return String.join("\n", texts);
    }

    /**
     * 计算图片尺寸
     * @param lines
     * @param font
     * @param rotationAngle
     * @return
     */
    public static int[] calculateSize(String[] lines, Font font, double rotationAngle){
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

        // 计算旋转后的尺寸
        int[] rotatedSize = calculateRotate(maxWidth, totalHeight, (int) rotationAngle);
        return rotatedSize;
    }


    public static int[] calculateRotate(double width,double height, double rotate) {
        // 原矩形 A 的长和宽
        double widthA = width;
        double heightA = height;

        // 旋转角度
        double angle = Math.toRadians(rotate);

        // 原矩形 A 的四个顶点 (以中心为原点计算)
        double[][] corners = {
                {widthA / 2, heightA / 2},
                {widthA / 2, -heightA / 2},
                {-widthA / 2, heightA / 2},
                {-widthA / 2, -heightA / 2}
        };

        // 旋转矩阵计算旋转后顶点的坐标
        double cosTheta = Math.cos(angle);
        double sinTheta = Math.sin(angle);
        double minX = Double.MAX_VALUE, maxX = Double.MIN_VALUE;
        double minY = Double.MAX_VALUE, maxY = Double.MIN_VALUE;

        for (double[] corner : corners) {
            double x = corner[0] * cosTheta - corner[1] * sinTheta;
            double y = corner[0] * sinTheta + corner[1] * cosTheta;

            minX = Math.min(minX, x);
            maxX = Math.max(maxX, x);
            minY = Math.min(minY, y);
            maxY = Math.max(maxY, y);
        }

        // 外接矩形的宽和高
        double rotatedWidth = maxX - minX;
        double rotatedHeight = maxY - minY;

        return new int[]{new BigDecimal(rotatedWidth).setScale(0, BigDecimal.ROUND_UP).intValue(),
                new BigDecimal(rotatedHeight).setScale(0, BigDecimal.ROUND_UP).intValue()};
    }

    /**
     * 创建单水印图片
     * @param content
     * @param width
     * @param height
     * @param color
     * @param font
     * @param rotate
     * @return
     * @throws IOException
     */
    public static BufferedImage createSingleWaterMark(String content, int width, int height, Color color, Font font, double rotate) throws IOException {
        // 获取bufferedImage对象
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        // 获取Graphics2d对象
        Graphics2D g2d = image.createGraphics();
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.0f));
        g2d.fillRect(0, 0, width, height);

        g2d.setComposite(AlphaComposite.SrcOver);
        // 设置字体颜色
        g2d.setColor(color);
        // 设置字体
        g2d.setFont(font);
        // 设置倾斜度
        g2d.rotate(-Math.toRadians(rotate), (double) image.getWidth() / 2, (double) image.getHeight() / 2);

        // 获取字体渲染上下文
        FontRenderContext context = g2d.getFontRenderContext();
        // 按行分割水印内容
        String[] lines = content.split("\n");
        double x = 0;
        // y坐标起始位置：图片高度的一半 减 (行数的一半 乘以 字体高度) 再减 行间距
        double y = (height/2)-(font.getStringBounds(lines[0],context).getHeight()*(lines.length/2)) - ((lines.length/2-1)*LINE_SPACE);

        // 绘制每一行水印
        for (String line : lines) {
            Rectangle2D bounds = font.getStringBounds(line, context);
            // 计算x和y坐标，使文字居中
            x = (width - bounds.getWidth()) / 2;
            // 如果超出图片高度，则停止绘制
            if (y > height) { break; }
            double ascent = -bounds.getY();
            double baseY = y + ascent;
            g2d.drawString(line, (int) x, (int) baseY);
            // 增加行间距
            y += bounds.getHeight() + LINE_SPACE;
        }
        // 恢复原始状态
        g2d.rotate(Math.toRadians(rotate), (double) image.getWidth() / 2, (double) image.getHeight() / 2);
        // 释放对象
        g2d.dispose();
        // 将图片写入字节流
        return image;
    }

    /**
     * 创建单水印图片
     * @param content
     * @param width
     * @param height
     * @param color
     * @param font
     * @param rotate
     * @return
     * @throws IOException
     */
    public static byte[] createSingleWaterMarkOfBytes(String content, int width, int height, Color color, Font font, double rotate) throws IOException {
        BufferedImage image = createSingleWaterMark(content, width, height, color, font, rotate);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageIO.write(image, "png", os);
        return os.toByteArray();
    }

    public static byte[] createMultipleWaterMarkOfBytes(String content, int width, int height, Color color, Font font, int horizontalGap, int verticalGap, double rotate) throws IOException {
        BufferedImage image = createMultipleWaterMark(content, width, height, color, font, horizontalGap, verticalGap, rotate);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageIO.write(image, "png", os);
        return os.toByteArray();
    }

    /**
     * 创建多水印图片
     *
     * @param content       水印内容
     * @param width         宽度
     * @param height        高度
     * @param color         颜色
     * @param font          字体
     * @param horizontalGap 水平间距
     * @param verticalGap   垂直间距
     * @param rotate       旋转角度
     * @return
     * @throws IOException
     */
    public static BufferedImage createMultipleWaterMark(String content, int width, int height, Color color, Font font, int horizontalGap, int verticalGap, double rotate) throws IOException {
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
        // 获取字体渲染上下文
        FontRenderContext context = g2d.getFontRenderContext();
        // 按行分割水印内容
        String[] lines = content.split("\n");
        int lineCount = lines.length;

        // 计算每个水印的宽度和高度
        double maxWidth = 0;
        double totalHeight = 0;
        for (String line : lines) {
            Rectangle2D bounds = font.getStringBounds(line, context);
            maxWidth = Math.max(maxWidth, bounds.getWidth());
            totalHeight += bounds.getHeight()+LINE_SPACE; // 增加固定行间距
        }

        // 计算最大半径，避免旋转后水印文字互相重叠
        double maxRadius = Math.max(maxWidth,totalHeight);

        // 计算可以放置水印的最大行数和列数
        int columns = Math.max((int) (width / (maxRadius + horizontalGap)), 1);
        int rows = Math.max((int) (height / (maxRadius + verticalGap)), 1);

        if (columns == 1 && rows == 1){
            double x = (width - maxWidth) / 2;
            double y = (height/2)-(font.getStringBounds(lines[0],context).getHeight()*(lines.length/2));
            // 倾斜角度
            double radians = Math.toRadians(rotate);
            double originX = x + maxWidth/2;
            double originY = y + totalHeight/2;
            g2d.rotate(-radians, originX, originY);

            for (int i = 0; i < lineCount; i++) {
                String line = lines[i];
                Rectangle2D bounds = font.getStringBounds(line, context);
                // 居中效果后的x坐标
                double centerX = x + (maxWidth - bounds.getWidth()) / 2;
                // y坐标
                g2d.drawString(line, (int) centerX, (int)y);
                y += bounds.getHeight() + LINE_SPACE; // 增加固定行间距
            }
            g2d.rotate(radians, originX, originY); // 恢复原始状态

        }else {
            // 绘制水印文字
            for (int row = 0; row < rows + 1; row++) {
                for (int col = 0; col < columns + 1; col++) {

                    // 计算水印文字的位置
                   double x = (col * (maxRadius + horizontalGap)) + (maxRadius / 10);
                   double y = (row * (maxRadius + verticalGap + LINE_SPACE)) + (maxRadius / 10);

                    // 倾斜角度
                    double radians = Math.toRadians(rotate);
                    double originX = x + maxWidth / 2;
                    double originY = y + totalHeight / 2;
                    g2d.rotate(-radians, originX, originY);

                    for (int i = 0; i < lineCount; i++) {
                        String line = lines[i];
                        Rectangle2D bounds = font.getStringBounds(line, context);
                        double ascent = bounds.getHeight() - bounds.getY();

                        // 居中效果后的x坐标
                        double centerX = x + (maxWidth - bounds.getWidth()) / 2;
                        // y坐标
                        double lineY = y - ascent;
                        g2d.drawString(line, (int) centerX, (int) lineY);
                        y += bounds.getHeight() + LINE_SPACE; // 增加固定行间距
                    }
                    g2d.rotate(radians, originX, originY); // 恢复原始状态
                }
            }
        }
        // 释放对象
        g2d.dispose();
        return image;
    }

    public static boolean isBlank(CharSequence cs) {
        int strLen;
        if (cs != null && (strLen = cs.length()) != 0) {
            for(int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return true;
        }
    }

    public static boolean isNotBlank(CharSequence cs){
        return !isBlank(cs);
    }

}
