package test.study.java.watermark.spire1218;

import com.spire.pdf.graphics.PdfTrueTypeFont;
import com.spire.presentation.*;
import com.spire.presentation.drawing.BackgroundType;
import com.spire.presentation.drawing.FillFormatType;
import com.spire.presentation.drawing.IImageData;
import com.spire.presentation.drawing.PictureFillType;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Dimension2D;
import java.awt.geom.Rectangle2D;
import java.io.File;

/**
 * @author sun yang
 * @date 2024/11/28
 */
public class PptTest {

    public static void text() throws Exception{
        //Create a Presentation object and load a sample file
        Presentation presentation = new Presentation();
        presentation.loadFromFile("F:\\watermark\\1218\\亚信安全2024浅色ppt模版.pptx");

        //Set the text of watermarks
        String watermarkText = "Confidential";

        //Measure the size of the watermark text
        Font font = new java.awt.Font("Arial", java.awt.Font.BOLD, 20);
        PdfTrueTypeFont trueTypeFont = new PdfTrueTypeFont(font);
        Dimension2D strSize = trueTypeFont.measureString(watermarkText);

        //Initialize x and y coordinate
        float x = 30;
        float y = 80;

        for (int rowNum = 0; rowNum < 4; rowNum++) {
            for (int colNum = 0; colNum < 4; colNum++) {

                //Add rectangle shapes to the first slide
                Rectangle2D rect = new Rectangle2D.Float(x, y, (float) strSize.getWidth() + 10, (float) strSize.getHeight());
                IAutoShape shape = presentation.getSlides().get(0).getShapes().appendShape(ShapeType.RECTANGLE, rect);

                //Set the style of the shapes
                shape.getFill().setFillType(FillFormatType.NONE);
                shape.getShapeStyle().getLineColor().setColor(new Color(1, 1, 1, 0));
                shape.setRotation(-45);
                shape.getLocking().setSelectionProtection(true);
                shape.getLine().setFillType(FillFormatType.NONE);

                //Add watermark text to the shapes
                shape.getTextFrame().setText(watermarkText);
                PortionEx textRange = shape.getTextFrame().getTextRange();

                //Set the style of the text ranges
                textRange.getFill().setFillType(FillFormatType.SOLID);
                textRange.setLatinFont(new TextFont(trueTypeFont.getName()));
                textRange.setFontMinSize(trueTypeFont.getSize());
                Color color = new Color(237,129,150,200);
                textRange.getFill().getSolidColor().setColor(color);

                x += (100 + strSize.getWidth());

            }
            x = 30;
            y += (100 + strSize.getHeight());
        }

        //Save the result document
        presentation.saveToFile("F:\\watermark\\1218\\result\\亚信安全2024浅色ppt模版.pptx", FileFormat.PPTX_2013);
        presentation.dispose();
    }


    public static void image() throws Exception{
        //Create a PowerPoint document.
        Presentation presentation = new Presentation();

        //Load the file from disk.
        presentation.loadFromFile("F:\\watermark\\1218\\亚信安全2024浅色ppt模版.pptx");

        //Get the image you want to add as image watermark.
        File file =new File("C:\\Users\\孙杨\\Desktop\\favicon.png");
        IImageData image = presentation.getImages().append(ImageIO.read(file));

        //Set the properties of SlideBackground, and then fill the image as watermark.
        presentation.getSlides().get(0).getSlideBackground().setType(BackgroundType.CUSTOM);
        presentation.getSlides().get(0).getSlideBackground().getFill().setFillType(FillFormatType.PICTURE);
        presentation.getSlides().get(0).getSlideBackground().getFill().getPictureFill().setFillType(PictureFillType.STRETCH);
        presentation.getSlides().get(0).getSlideBackground().getFill().getPictureFill().getPicture().setEmbedImage(image);

        String result = "F:\\watermark\\1218\\result\\亚信安全2024浅色ppt模版.pptx";
        //Save to file.
        presentation.saveToFile(result, FileFormat.PPTX_2013);
    }

    public static void main(String[] args) throws Exception {

        image();


    }

}
