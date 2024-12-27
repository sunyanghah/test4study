package test.study.java.watermark.poi;

import org.apache.poi.hslf.usermodel.HSLFObjectShape;
import org.apache.poi.hslf.usermodel.HSLFPictureData;
import org.apache.poi.hslf.usermodel.HSLFSlideMaster;
import org.apache.poi.hslf.usermodel.HSLFSlideShow;
import org.apache.poi.sl.usermodel.PictureData;
import test.study.java.watermark.WatermarkUtil;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author sun yang
 * @date 2024/11/19
 */
public class Ppt2Test {

    public static void main(String[] args) throws Exception{

        // 创建一个 .ppt 文件或打开已有文件
        HSLFSlideShow ppt = new HSLFSlideShow(new FileInputStream("F:\\watermark\\poi\\ppt.ppt"));

        // 获取母版幻灯片
        HSLFSlideMaster master = ppt.getSlideMasters().get(0);

        // 在母版上添加图片作为背景
        Dimension pageSize = ppt.getPageSize();

        // 加载图片
        byte[] pictureData = WatermarkUtil.createMultipleWaterMarkOfBytes("这是ppt水印", 300, 300,
                new Color(255, 0, 0, 205), new Font("微软雅黑", Font.BOLD, 20),10,10,0);
//        byte[] pictureData = createWaterMark("这是pptx水印", pageSize.width, pageSize.height,
//                new Color(255, 0, 0, 100), new Font("微软雅黑", Font.BOLD, 20));

//        String imagePath = "C:\\Users\\孙杨\\Desktop\\微信图片_20241210093918.jpg"; // 替换为图片路径
//        FileInputStream fileInputStream = new FileInputStream(imagePath);
//        byte[] pictureData = new byte[fileInputStream.available()];
//        fileInputStream.read(pictureData);

        HSLFPictureData pd = ppt.addPicture(pictureData, PictureData.PictureType.PNG);
//        HSLFPictureShape pictureShape = new HSLFPictureShape(pd);
//        pictureShape.setAnchor(new Rectangle(0, 0, 300, 300));

//        master.addShape(pictureShape);
        // 将背景图片设置到母版图层
        HSLFObjectShape oleShape = master.createOleShape(pd);
        oleShape.setAnchor(new Rectangle(0, 0, 300, 300));


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
