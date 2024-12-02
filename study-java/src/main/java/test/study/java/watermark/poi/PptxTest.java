package test.study.java.watermark.poi;

import org.apache.poi.sl.usermodel.PictureData.PictureType;
import org.apache.poi.xslf.usermodel.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author sun yang
 * @date 2024/11/19
 */
public class PptxTest {

    public static void main(String[] args) throws Exception{
        // create a ppt
        XMLSlideShow ppt = new XMLSlideShow();

        //生成水印
        byte[] waterMarkBytes = createWaterMark("这是pptx水印", 200, 150, new Color(255, 0, 0, 100)
                , new Font("微软雅黑", Font.BOLD, 20));

        XSLFPictureData pd = ppt.addPicture(waterMarkBytes, PictureType.JPEG);
        XSLFSlideMaster slideMaster = ppt.getSlideMasters().get(0);
        XSLFSlideLayout slidelayout = slideMaster.getLayout(SlideLayout.TITLE_AND_CONTENT);
        XSLFPictureShape ps = slidelayout.createPicture(pd);
        ps.setAnchor(new Rectangle2D.Double(100, 100, 400, 400));

        XSLFSlide sl = ppt.createSlide(slidelayout);
        ((XSLFAutoShape)sl.getShapes().get(0)).setText("title");
        ((XSLFAutoShape)sl.getShapes().get(1)).setText("content");

        FileOutputStream fos = new FileOutputStream("F:\\watermark\\1119\\pptxtt.pptx");
        ppt.write(fos);
        fos.close();
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

}
