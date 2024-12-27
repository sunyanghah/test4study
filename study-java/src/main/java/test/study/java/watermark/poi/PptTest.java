package test.study.java.watermark.poi;

import org.apache.poi.hslf.usermodel.*;
import org.apache.poi.sl.usermodel.PictureData.PictureType;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author sun yang
 * @date 2024/11/19
 */
public class PptTest {

    public static void main(String[] args) throws Exception{

        String inFilePath = "F:\\watermark\\poi\\ppt.ppt";
        String outFilePath = "F:\\watermark\\poi\\result\\ppt.ppt";
//
//        String inFilePath = "F:\\watermark\\libre\\ppt.ppt";
//        String outFilePath = "F:\\watermark\\libre\\result\\ppt.ppt";

// 创建一个 .ppt 文件或打开已有文件
        HSLFSlideShow ppt = new HSLFSlideShow(new FileInputStream("F:\\watermark\\poi\\ppt.ppt"));

        List<HSLFSlideMaster> slideMasters = ppt.getSlideMasters();

        // 设置图片大小和位置，使其覆盖整个幻灯片
        Dimension pageSize = ppt.getPageSize();

        // 加载背景图片
        byte[] pictureData = createWaterMark("这是pptx水印", pageSize.width, pageSize.height, new Color(255, 0, 0, 100)
                , new Font("微软雅黑", Font.BOLD, 20));

        // 将图片添加到幻灯片中
        HSLFPictureData pd = ppt.addPicture(pictureData, PictureType.PNG);
//        HSLFPictureShape pictureShape = new HSLFPictureShape(pd);
//        pictureShape.setAnchor(new Rectangle(0, 0, pageSize.width, pageSize.height));

        for (HSLFSlideMaster master : slideMasters) {
            HSLFObjectShape oleShape = master.createOleShape(pd);
            oleShape.setAnchor(new Rectangle(0, 0, pageSize.width, pageSize.height));
        }

        // 保存文件
        try (FileOutputStream out = new FileOutputStream("F:\\watermark\\poi\\result\\ppt.ppt")) {
            ppt.write(out);
        }

        System.out.println("PPT created with background image!");
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
    public static byte[] createWaterMark(String content, int width, int height, Color color, Font font) throws IOException {
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
