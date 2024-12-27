package test.study.java.watermark.poi;

import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.xslf.usermodel.*;
import test.study.java.watermark.WatermarkUtil;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sun yang
 * @date 2024/12/27
 */
public class PptxImageTest {

    public static List< Class<? extends XSLFShape>> needHandleShapes = Arrays.asList(XSLFPictureShape.class,XSLFGraphicFrame.class,XSLFTable.class);

    public static void main(String[] args) throws Exception {
        ByteArrayOutputStream outputStream = addToPptx(new FileInputStream("F:\\watermark\\poi\\pptx.pptx"),
                new String[]{"这是pptx水印四", "第二行", "第三行"},
                14,
                "#0000ff",
                100,
                45);

        outputStream.writeTo(new FileOutputStream("F:\\watermark\\poi\\result\\pptx.pptx"));
    }

    /**
     * Add watermark to pptx
     * @param originFilePath 原文件路径
     * @param targetPath 目标文件路径
     * @param textArr 水印文字数组，每个一行
     * @param fontSize 字体大小
     * @param fontColor 字体颜色 #FFFFFF 格式
     * @param opacity 透明度 0-100
     * @param rotate 旋转角度 0-360
     * @throws Exception
     */
    public static void addToPptx(String originFilePath,String targetPath,String[] textArr,
                                 int fontSize,String fontColor,int opacity,int rotate) throws Exception {

        File originFile = new File(originFilePath);
        ByteArrayOutputStream outputStream = addToPptx(new FileInputStream(originFile),
                textArr,
                fontSize,
                fontColor,
                opacity,
                rotate);

        outputStream.writeTo(new FileOutputStream(targetPath + File.separator + originFile.getName()));
    }

    /**
     * Add watermark to pptx
     * @param inputStream 原文件流
     * @param textArr 水印文字数组，每个一行
     * @param fontSize 字体大小
     * @param fontColor 字体颜色 #FFFFFF 格式
     * @param opacity 透明度 0-100
     * @param rotate 旋转角度 0-360
     * @throws Exception
     */
    public static ByteArrayOutputStream addToPptx(InputStream inputStream, String[] textArr,
                                                  int fontSize, String fontColor, int opacity, int rotate) throws Exception {

        ZipSecureFile.setMinInflateRatio(0.0001);
        // create a ppt
        XMLSlideShow ppt = new XMLSlideShow(inputStream);

        // 加载字体库文件
//        InputStream fontStream = PptxBrightWatermark.class.getResourceAsStream("/simfang.ttf");
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
        byte[] waterMarkBytes = WatermarkUtil.createSingleWaterMarkOfBytes(
                WatermarkUtil.transText(textArr),
                width,
                height,
                WatermarkUtil.hexStringToColor(fontColor,opacity),
                font,
                rotate);

        XSLFPictureData pd = ppt.addPicture(waterMarkBytes, PictureData.PictureType.PNG);

        List<XSLFSlideMaster> slideMasters = ppt.getSlideMasters();
        for (XSLFSlideMaster slideMaster : slideMasters) {
            int row = (int) Math.ceil(pageSize.getHeight() / (height + verticalGap));
            int col = (int) Math.ceil(pageSize.getWidth() / (width + horizontalGap));

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {

                    // 设置水印位置
                    double x = j * (width + horizontalGap);
                    double y = i * (height + verticalGap);

                    XSLFPictureShape pictureShape = slideMaster.createPicture(pd);
                    pictureShape.setAnchor(new Rectangle2D.Double(x, y, width, height));

                }
            }
        }

        List<XSLFSlide> slides = ppt.getSlides();
        for (XSLFSlide slide : slides) {

            List<Rectangle2D> needHandleAnchorList = new ArrayList<>();

            boolean isNeedHandle = false;
            List<XSLFShape> shapes = slide.getShapes();
            for (XSLFShape shape : shapes) {
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
                        XSLFPictureShape pictureShape = slide.createPicture(pd);
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

}
