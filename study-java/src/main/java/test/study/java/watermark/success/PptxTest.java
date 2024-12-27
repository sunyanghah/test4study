package test.study.java.watermark.success;

import com.spire.presentation.FileFormat;
import com.spire.presentation.IMasterSlide;
import com.spire.presentation.ISlide;
import com.spire.presentation.Presentation;
import com.spire.presentation.drawing.BackgroundType;
import com.spire.presentation.drawing.FillFormatType;
import com.spire.presentation.drawing.IImageData;
import com.spire.presentation.drawing.PictureFillType;
import test.study.java.watermark.WatermarkUtil;

import java.awt.*;
import java.awt.geom.Dimension2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * @author sun yang
 * @date 2024/11/28
 */
public class PptxTest {

    public static void main(String[] args) throws Exception {
        ByteArrayOutputStream outputStream = addToPpt(new FileInputStream("F:\\watermark\\1218\\信界-业务安全解决方案V1.0.1007.03.pptx"),
                new String[]{"这是pptx水印四", "第二行", "第三行"},
                14,
                "#FF0000",
                100,
                45);

        outputStream.writeTo(new FileOutputStream("F:\\watermark\\1218\\result\\信界-业务安全解决方案V1.0.1007.03.pptx"));
    }

    public static ByteArrayOutputStream addToPpt(InputStream inputStream, String[] textArr,
                                                 int fontSize, String fontColor, int opacity, int rotate) throws Exception {

        //Create a PowerPoint document.
        Presentation presentation = new Presentation();

        presentation.loadFromStream(inputStream,FileFormat.AUTO);

        Dimension2D size = presentation.getSlideSize().getSize();

        //Get the image you want to add as image watermark.
        BufferedImage waterMark = WatermarkUtil.createMultipleWaterMark(
                WatermarkUtil.transText(textArr),
                (int)size.getWidth(),
                (int) size.getHeight(),
                WatermarkUtil.hexStringToColor(fontColor,opacity),
                new Font("微软雅黑", Font.PLAIN, fontSize),
                80,80,
                rotate);

        IImageData image = presentation.getImages().append(waterMark);

        //get the first slide master
        IMasterSlide masterSlide = presentation.getMasters().get(0);

        //Set the properties of SlideBackground, and then fill the image as watermark.
        masterSlide.getSlideBackground().setType(BackgroundType.CUSTOM);
        masterSlide.getSlideBackground().getFill().setFillType(FillFormatType.PICTURE);
        masterSlide.getSlideBackground().getFill().getPictureFill().setFillType(PictureFillType.STRETCH);
        masterSlide.getSlideBackground().getFill().getPictureFill().getPicture().setEmbedImage(image);

        for (ISlide slide : presentation.getSlides().toArray()) {
            slide.getSlideBackground().setType(BackgroundType.CUSTOM);
            slide.getSlideBackground().getFill().setFillType(FillFormatType.PICTURE);
            slide.getSlideBackground().getFill().getPictureFill().setFillType(PictureFillType.STRETCH);
            slide.getSlideBackground().getFill().getPictureFill().getPicture().setEmbedImage(image);
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        presentation.saveToFile(outputStream, FileFormat.AUTO);

        return outputStream;
    }


}
