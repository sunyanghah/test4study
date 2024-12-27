package test.study.java.watermark.poi;

import org.apache.poi.hslf.model.MovieShape;
import org.apache.poi.hslf.usermodel.*;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.sl.usermodel.PictureData;
import test.study.java.watermark.WatermarkUtil;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sun yang
 * @date 2024/11/19
 */
public class PptImageTest {

    public static java.util.List< Class<? extends HSLFShape>> needHandleShapes = Arrays.asList(HSLFPictureShape.class, MovieShape.class, HSLFTable.class);

    public static void main(String[] args) throws Exception {
        ByteArrayOutputStream outputStream = addToPpt(new FileInputStream("F:\\watermark\\poi\\ppt.ppt"),
                new String[]{"这是pptx水印四", "第二行", "第三行"},
                14,
                "#0000ff",
                100,
                45);

        outputStream.writeTo(new FileOutputStream("F:\\watermark\\poi\\result\\ppt.ppt"));
    }

    /**
     * Add watermark to ppt
     * @param originFilePath 原文件路径
     * @param targetPath 目标文件路径
     * @param textArr 水印文字数组，每个一行
     * @param fontSize 字体大小
     * @param fontColor 字体颜色 #FFFFFF 格式
     * @param opacity 透明度 0-100
     * @param rotate 旋转角度 0-360
     * @throws Exception
     */
    public static void addToPpt(String originFilePath,String targetPath,String[] textArr,
                                 int fontSize,String fontColor,int opacity,int rotate) throws Exception {

        File originFile = new File(originFilePath);
        ByteArrayOutputStream outputStream = addToPpt(new FileInputStream(originFile),
                textArr,
                fontSize,
                fontColor,
                opacity,
                rotate);

        outputStream.writeTo(new FileOutputStream(targetPath + File.separator + originFile.getName()));
    }

    /**
     * Add watermark to ppt
     * @param inputStream 原文件流
     * @param textArr 水印文字数组，每个一行
     * @param fontSize 字体大小
     * @param fontColor 字体颜色 #FFFFFF 格式
     * @param opacity 透明度 0-100
     * @param rotate 旋转角度 0-360
     * @throws Exception
     */
    public static ByteArrayOutputStream addToPpt(InputStream inputStream, String[] textArr,
                                                  int fontSize, String fontColor, int opacity, int rotate) throws Exception {

        ZipSecureFile.setMinInflateRatio(0.0001);
        // create a ppt
        HSLFSlideShow ppt = new HSLFSlideShow(inputStream);

        // 加载字体库文件
//        InputStream fontStream = PptBrightWatermark.class.getResourceAsStream("/simfang.ttf");
        InputStream fontStream = new FileInputStream("D:\\IDEA\\gitWork\\test4study\\study-java\\src\\main\\java\\test\\study\\java\\mianshiti2024\\simfang.ttf");
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontStream);
        font = font.deriveFont(Font.PLAIN, fontSize);

        Dimension pageSize = ppt.getPageSize().getSize();

        int[] imageSize = WatermarkUtil.calculateSize(textArr, font, rotate);

        int width = imageSize[0];
        int height = imageSize[1];

        int verticalGap = 100;
        int horizontalGap = 100;

        //Get the image you want to add as image watermark.
        byte[] waterMarkBytes = createSingleWaterMarkOfBytes(
                WatermarkUtil.transText(textArr),
                width,
                height,
                WatermarkUtil.hexStringToColor(fontColor,opacity),
                font,
                rotate,
                opacity);

        HSLFPictureData pd = ppt.addPicture(waterMarkBytes, PictureData.PictureType.PNG);

        java.util.List<HSLFSlideMaster> slideMasters = ppt.getSlideMasters();
        for (HSLFSlideMaster slideMaster : slideMasters) {
            int row = (int) Math.ceil(pageSize.getHeight() / (height + verticalGap));
            int col = (int) Math.ceil(pageSize.getWidth() / (width + horizontalGap));

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {

                    // 设置水印位置
                    double x = j * (width + horizontalGap);
                    double y = i * (height + verticalGap);

                    HSLFPictureShape pictureShape = slideMaster.createPicture(pd);
                    pictureShape.setAnchor(new Rectangle2D.Double(x, y, width, height));

                }
            }
        }

        java.util.List<HSLFSlide> slides = ppt.getSlides();
        for (HSLFSlide slide : slides) {

            java.util.List<Rectangle2D> needHandleAnchorList = new ArrayList<>();

            boolean isNeedHandle = false;
            List<HSLFShape> shapes = slide.getShapes();
            for (HSLFShape shape : shapes) {
                if (needHandleShapes.contains(shape.getClass())) {
                    Rectangle2D anchor = shape.getAnchor();
                    needHandleAnchorList.add(anchor);
                    isNeedHandle = true;
                }
            }

            if (!isNeedHandle) {
                continue;
            }

            int row = (int) Math.ceil(pageSize.getHeight() / (height + verticalGap));
            int col = (int) Math.ceil(pageSize.getWidth() / (width + horizontalGap));

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {

                    // 水印位置
                    double x = j * (width + horizontalGap);
                    double y = i * (height + verticalGap);
                    Rectangle2D.Double watermarkAnchor = new Rectangle2D.Double(x, y, width, height);

                    boolean needToDraw = false;

                    // 判断水印是否在需要处理的shape上
                    for (Rectangle2D rectangle2D : needHandleAnchorList) {
                        if (isOverlapping(watermarkAnchor.getX(),watermarkAnchor.getY(),watermarkAnchor.getWidth(),watermarkAnchor.getHeight(),
                                rectangle2D.getX(),rectangle2D.getY(),rectangle2D.getWidth(),rectangle2D.getHeight())) {
                            needToDraw = true;
                            break;
                        }
                    }

                    if (needToDraw){
                        HSLFPictureShape pictureShape = slide.createPicture(pd);
                        pictureShape.setAnchor(watermarkAnchor);
                    }

                }
            }
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        ppt.write(outputStream);

        return outputStream;
    }

    public static boolean isOverlapping(double x1, double y1, double w1, double h1, double x2, double y2, double w2, double h2) {
        // 判断是否不重合
        if (x1 + w1 <= x2 || x2 + w2 <= x1 || y1 + h1 <= y2 || y2 + h2 <= y1) {
            return false; // 没有重合部分
        }
        return true; // 存在重合部分
    }

    public static int LINE_SPACE = 5;

    public static byte[] createSingleWaterMarkOfBytes(String content, int width, int height, Color color, Font font, double rotate,float opacity) throws IOException {
        BufferedImage image = createSingleWaterMark(content, width, height, color, font, rotate, opacity);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageIO.write(image, "png", os);
        return os.toByteArray();
    }

    public static BufferedImage createSingleWaterMark(String content, int width, int height, Color color, Font font, double rotate,float opacity) throws IOException {
        // 获取bufferedImage对象
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        // 获取Graphics2d对象
        Graphics2D g2d = image.createGraphics();
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.0f));
        g2d.fillRect(0, 0, width, height);

        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity/100));
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

}
