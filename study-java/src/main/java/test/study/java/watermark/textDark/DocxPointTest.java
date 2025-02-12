package test.study.java.watermark.textDark;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;

/**
 * @author sun yang
 * @date 2024/12/30
 */
public class DocxPointTest {

    public static void main(String[] args) throws Exception{

        String inputFilePath = "F:\\watermark\\textDark\\docx.docx";
        String outputFilePath = "F:\\watermark\\textDark\\result\\docx.docx";

        addOfCharacter(inputFilePath,outputFilePath,123L);
        read(outputFilePath);

    }

    private static void read(String targetFilePath) throws Exception{

        XWPFDocument document = new XWPFDocument(new FileInputStream(targetFilePath));
        List<XWPFParagraph> paragraphList = document.getParagraphs();
        for (XWPFParagraph paragraph : paragraphList) {
            String text = paragraph.getText();
            if (StringUtils.isBlank(text)){
                continue;
            }
            Long decode = TextDarkUtils.decode(text);
            if (decode != null){
                System.out.println("水印内容："+decode);
               return;
            }
        }

    }


    public static boolean isPunctuation(char c) {
        // 使用Character类的isLetterOrDigit方法判断字符是否是字母或数字
        // 如果不是字母或数字，则可能是标点符号
        return ' ' == c || (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c));
    }

    /**
     * 每多少字
     */
    private static void addOfWordCount(String inputFilePath,String outputFilePath,Long watermarkId) throws Exception{
        // 创建一个新的 Word 文档
        XWPFDocument document = new XWPFDocument(new FileInputStream(inputFilePath));

        // 生成隐藏字符
        String invisibleWatermark =  TextDarkUtils.encode(watermarkId);

        long countLimit = 50L;
        long countIndex = 0L;

        List<XWPFParagraph> paragraphs = document.getParagraphs();

        for (XWPFParagraph paragraph : paragraphs) {

            List<XWPFRun> runs = paragraph.getRuns();
            for (XWPFRun characterRun : runs) {
                String text = characterRun.text();
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

                characterRun.setText(handleText.toString(),0);
            }
        }

        // 保存文档
        try (FileOutputStream fos = new FileOutputStream(outputFilePath)) {
            document.write(fos);
        }

        System.out.println("Hidden text added to the Word document.");
    }

    /**
     * 每段
     */
    public static void addOfParagraph(String inputFilePath,String outputFilePath,Long watermarkId) throws Exception{
        // 创建一个新的 Word 文档
        XWPFDocument document = new XWPFDocument(new FileInputStream(inputFilePath));

        // 生成隐藏字符
        String invisibleWatermark =  TextDarkUtils.encode(watermarkId);

        ///////////表格////////////////
        List<XWPFTable> tables = document.getTables();
        for (XWPFTable table : tables) {
            String text = table.getText();
            System.out.println(text);
        }



        //////////段落////////////////
        List<XWPFParagraph> paragraphs = document.getParagraphs();

        for (XWPFParagraph paragraph : paragraphs) {

            String paragraphText = paragraph.getText();
            if (StringUtils.isBlank(paragraphText)){
                continue;
            }

            long textCount = paragraphText.length();
            long countIndex = 0L;

            List<XWPFRun> runs = paragraph.getRuns();
            for (XWPFRun characterRun : runs) {
                String text = characterRun.text();
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
                    if (countIndex == textCount/2){
                        handleText.append(invisibleWatermark);
                    }
                }

                characterRun.setText(handleText.toString(),0);
            }
        }

        // 保存文档
        try (FileOutputStream fos = new FileOutputStream(outputFilePath)) {
            document.write(fos);
        }

        System.out.println("Hidden text added to the Word document.");
    }

    /**
     * 标点符号
     */
    public static void addOfPunctuation(String inputFilePath,String outputFilePath,Long watermarkId) throws Exception{
        // 创建一个新的 Word 文档
        XWPFDocument document = new XWPFDocument(new FileInputStream(inputFilePath));

        // 生成隐藏字符
        String invisibleWatermark =  TextDarkUtils.encode(watermarkId);

        List<XWPFParagraph> paragraphs = document.getParagraphs();

        for (XWPFParagraph paragraph : paragraphs) {

            List<XWPFRun> runs = paragraph.getRuns();
            for (XWPFRun characterRun : runs) {
                String text = characterRun.text();
                if (StringUtils.isBlank(text)){
                    continue;
                }

                StringBuilder handleText = new StringBuilder();
                char[] chars = text.toCharArray();
                for (char aChar : chars) {
                    if (isPunctuation(aChar)){
                        handleText.append(invisibleWatermark);
                    }
                    handleText.append(aChar);
                }

                characterRun.setText(handleText.toString(),0);
            }
        }

        // 保存文档
        try (FileOutputStream fos = new FileOutputStream(outputFilePath)) {
            document.write(fos);
        }

        System.out.println("Hidden text added to the Word document.");
    }

    /**
     * 指定字符
     */
    public static void addOfCharacter(String inputFilePath,String outputFilePath,Long watermarkId) throws Exception{
        // 创建一个新的 Word 文档
        XWPFDocument document = new XWPFDocument(new FileInputStream(inputFilePath));

        List<String> characterList = Arrays.asList("嘿嘿","哈哈");

        // 生成隐藏字符
        String invisibleWatermark =  TextDarkUtils.encode(watermarkId);

        List<XWPFParagraph> paragraphs = document.getParagraphs();

        for (XWPFParagraph paragraph : paragraphs) {

            List<XWPFRun> runs = paragraph.getRuns();
            for (XWPFRun characterRun : runs) {
                String text = characterRun.text();
                if (StringUtils.isBlank(text)){
                    continue;
                }

                for (String character : characterList) {
                    if (text.contains(character)){
                        text = text.replace(character,invisibleWatermark+character);
                    }
                }

                characterRun.setText(text,0);
            }
        }

        // 保存文档
        try (FileOutputStream fos = new FileOutputStream(outputFilePath)) {
            document.write(fos);
        }

        System.out.println("Hidden text added to the Word document.");
    }

}
