package test.study.java.watermark.textDark;

import org.apache.poi.xslf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

/**
 * @author sun yang
 * @date 2024/12/30
 */
public class PptxTest {

    public static void main(String[] args) throws Exception{

        String inputFilePath = "F:\\watermark\\textDark\\pptx.pptx";
        String outputFilePath = "F:\\watermark\\textDark\\result\\pptx.pptx";

        addContentDark(inputFilePath, outputFilePath);
        read(outputFilePath);

    }

    private static void addContentDark(String inputFilePath, String outputFilePath) throws Exception{

        XMLSlideShow ppt = new XMLSlideShow(new FileInputStream(inputFilePath));

        String invisibleWatermark =  TextDarkUtils.encode(123L);

        List<XSLFSlide> slides = ppt.getSlides();
        for (XSLFSlide slide : slides) {
            List<XSLFShape> shapes = slide.getShapes();
            for (XSLFShape shape : shapes) {
                if (shape instanceof XSLFTextShape){
                    XSLFTextShape textShape = (XSLFTextShape) shape;
                    List<XSLFTextParagraph> textParagraphs = textShape.getTextParagraphs();
                    for (XSLFTextParagraph textParagraph : textParagraphs) {
                        List<XSLFTextRun> textRuns = textParagraph.getTextRuns();
                        if (textRuns != null && textRuns.size() > 0){
                            XSLFTextRun xslfTextRun = textRuns.get(0);
                            String rawText = xslfTextRun.getRawText();
                            int centerPos = rawText.length()/2;
                            String richTextString = rawText.substring(0,centerPos) + invisibleWatermark + rawText.substring(centerPos);
                            xslfTextRun.setText(richTextString);
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

        XMLSlideShow ppt = new XMLSlideShow(new FileInputStream(targetFilePath));
        List<XSLFSlide> slides = ppt.getSlides();
        for (XSLFSlide slide : slides) {
            List<XSLFShape> shapes = slide.getShapes();
            for (XSLFShape shape : shapes) {
                if (shape instanceof XSLFTextShape){
                    XSLFTextShape textShape = (XSLFTextShape) shape;
                    String text = textShape.getText();
                    System.out.println("水印内容："+TextDarkUtils.decode(text));
                }
            }
        }

    }

}
