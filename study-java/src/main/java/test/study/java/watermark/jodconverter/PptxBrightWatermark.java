package test.study.java.watermark.jodconverter;

import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFPictureData;
import org.apache.poi.xslf.usermodel.XSLFRelation;
import org.apache.poi.xslf.usermodel.XSLFSlideMaster;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlip;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRelativeRect;
import org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties;
import test.study.java.watermark.WatermarkUtil;

import java.awt.*;
import java.io.*;
import java.util.List;

/**
 * @author sun yang
 * @date 2024/11/28
 */
public class PptxBrightWatermark {

    public static void main(String[] args) throws Exception {
        ByteArrayOutputStream outputStream = addToPptx(new FileInputStream("F:\\watermark\\libre\\pptx.pptx"),
                new String[]{"这是pptx水印四", "第二行", "第三行"},
                14,
                "#FF0000",
                100,
                45);

        outputStream.writeTo(new FileOutputStream("F:\\watermark\\libre\\result\\pptx.pptx"));
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
        InputStream fontStream = new FileInputStream("D:\\IDEA\\gitWork\\test4study\\study-java\\src\\main\\java\\test\\study\\java\\mianshiti2024\\simfang.ttf");
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontStream);
        font = font.deriveFont(Font.PLAIN, fontSize);

        Dimension size = ppt.getPageSize().getSize();

        //Get the image you want to add as image watermark.
        byte[] waterMarkBytes = WatermarkUtil.createMultipleWaterMarkOfBytes(
                WatermarkUtil.transText(textArr),
                (int)size.getWidth(),
                (int) size.getHeight(),
                WatermarkUtil.hexStringToColor(fontColor,opacity),
                font,
                80,80,
                rotate);

        XSLFPictureData pd = ppt.addPicture(waterMarkBytes, PictureData.PictureType.JPEG);

        // 新版实现，仅对已有母版设置水印图片背景
        List<XSLFSlideMaster> slideMasters = ppt.getSlideMasters();
        for (XSLFSlideMaster master : slideMasters) {
            // 设置背景
            CTBackgroundProperties backgroundProperties = master.getXmlObject().getCSld().addNewBg().addNewBgPr();
            CTBlipFillProperties blipFillProperties = backgroundProperties.addNewBlipFill();
            // 使用图片填充背景
            CTRelativeRect ctRelativeRect = blipFillProperties.addNewStretch().addNewFillRect();
            String idx = master.addRelation(null, XSLFRelation.IMAGES, pd).getRelationship().getId();
            CTBlip blib = blipFillProperties.addNewBlip();
            blib.setEmbed(idx);
            ctRelativeRect.setB(0);
            ctRelativeRect.setL(0);
            ctRelativeRect.setT(0);
            ctRelativeRect.setR(0);
        }

        // 这是老实现，未对已有母版进行处理
//        XSLFSlideMaster slideMaster = ppt.getSlideMasters().get(0);
//        XSLFSlideLayout slidelayout = slideMaster.getLayout(SlideLayout.BLANK);
//        XSLFPictureShape ps = slidelayout.createPicture(pd);
//        ps.setAnchor(new Rectangle2D.Double(0, 0, size.getWidth(), size.getHeight()));
//
//        List<XSLFSlide> slides = ppt.getSlides();
//        for (XSLFSlide slide : slides) {
//            XSLFSlideLayout layout = slide.getSlideLayout();
//            XSLFPictureShape slidePs = layout.createPicture(pd);
//            slidePs.setAnchor(new Rectangle2D.Double(0, 0, size.getWidth(), size.getHeight()));
//        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        ppt.write(outputStream);

        return outputStream;
    }


}
