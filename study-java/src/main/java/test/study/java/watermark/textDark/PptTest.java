package test.study.java.watermark.textDark;

import org.apache.poi.hslf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

/**
 * @author sun yang
 * @date 2024/12/30
 */
public class PptTest {

    public static void main(String[] args) throws Exception{

        String inputFilePath = "F:\\watermark\\textDark\\ppt.ppt";
        String outputFilePath = "F:\\watermark\\textDark\\result\\ppt.ppt";

        addContentDark(inputFilePath, outputFilePath);
        read(outputFilePath);

    }

    private static void addContentDark(String inputFilePath, String outputFilePath) throws Exception{

        HSLFSlideShow ppt = new HSLFSlideShow(new FileInputStream(inputFilePath));

        String invisibleWatermark =  TextDarkUtils.encode(123L);

        List<HSLFSlide> slides = ppt.getSlides();
        for (HSLFSlide slide : slides) {
            List<HSLFShape> shapes = slide.getShapes();
            for (HSLFShape shape : shapes) {
                if (shape instanceof HSLFTextShape){
                    HSLFTextShape textShape = (HSLFTextShape) shape;
                    List<HSLFTextParagraph> textParagraphs = textShape.getTextParagraphs();
                    for (HSLFTextParagraph textParagraph : textParagraphs) {
                        List<HSLFTextRun> textRuns = textParagraph.getTextRuns();
                        if (textRuns != null && textRuns.size() > 0){
                            HSLFTextRun hslfTextRun = textRuns.get(0);
                            String rawText = hslfTextRun.getRawText();
                            int centerPos = rawText.length()/2;
                            String richTextString = rawText.substring(0,centerPos) + invisibleWatermark + rawText.substring(centerPos);
                            hslfTextRun.setText(richTextString);
                        }
                    }
                }
            }
        }

        try (FileOutputStream fos = new FileOutputStream(outputFilePath)) {
            ppt.write(fos);
        }

        System.out.println("Hidden text added to the Excel document.");

    }

    private static void read(String targetFilePath) throws Exception{

        HSLFSlideShow ppt = new HSLFSlideShow(new FileInputStream(targetFilePath));
        List<HSLFSlide> slides = ppt.getSlides();
        for (HSLFSlide slide : slides) {
            List<HSLFShape> shapes = slide.getShapes();
            for (HSLFShape shape : shapes) {
                if (shape instanceof HSLFTextShape){
                    HSLFTextShape textShape = (HSLFTextShape) shape;
                    String text = textShape.getText();
                    System.out.println("水印内容："+TextDarkUtils.decode(text));
                }
            }
        }

    }

}
