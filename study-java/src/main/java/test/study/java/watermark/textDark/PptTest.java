package test.study.java.watermark.textDark;

import org.apache.commons.lang3.StringUtils;
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

        addOfWordCount(inputFilePath, outputFilePath);
        read(outputFilePath);

    }

    private static void addOfCenter(String inputFilePath, String outputFilePath) throws Exception{

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

    private static void addOfWordCount(String inputFilePath, String outputFilePath) throws Exception{

        HSLFSlideShow ppt = new HSLFSlideShow(new FileInputStream(inputFilePath));

        String invisibleWatermark =  TextDarkUtils.encode(123L);

        long countLimit = 50L;
        long countIndex = 0L;

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
                            for (HSLFTextRun textRun : textRuns) {
                                String text = textRun.getRawText();
                                if (StringUtils.isBlank(text)){
                                    continue;
                                }

                                StringBuilder handleText = new StringBuilder();
                                char[] chars = text.toCharArray();
                                for (char aChar : chars) {
                                    handleText.append(aChar);
                                    if (Character.isISOControl(aChar) || Character.getType(aChar) == Character.CONTROL ||
                                            Character.getType(aChar) == Character.FORMAT || !Character.isDefined(aChar)){
                                        continue;
                                    }
                                    countIndex++;
                                    if (countIndex > 0 && countIndex % countLimit == 0){
                                        handleText.append(invisibleWatermark);
                                    }
                                }
                                textRun.setText(handleText.toString());
                            }
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
                    if (StringUtils.isBlank(text)){
                        continue;
                    }
                    Long decode = TextDarkUtils.decode(text);
                    if (decode != null){
                        System.out.println("水印内容："+ decode);
                        return;
                    }
                }
            }
        }

    }

}
