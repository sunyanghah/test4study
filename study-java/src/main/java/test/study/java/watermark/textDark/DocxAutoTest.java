package test.study.java.watermark.textDark;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sun yang
 * @date 2024/12/30
 */
public class DocxAutoTest {

    private static int maxTextLength = 20;
    private static int minTextLength = 10;

    public static void main(String[] args) throws Exception{

        String inputFilePath = "F:\\watermark\\textDark\\docx.docx";
        String outputFilePath = "F:\\watermark\\textDark\\result\\docx.docx";

        addOfAuto(inputFilePath,outputFilePath,123L);
        read(outputFilePath);

    }

    private static void addOfAuto(String inputFilePath,String outputFilePath,Long watermarkId) throws Exception{
        // 创建一个新的 Word 文档
        XWPFDocument document = new XWPFDocument(new FileInputStream(inputFilePath));

        // 在文档开头插入不可见字符（例如零宽度空格）
        String invisibleWatermark =  TextDarkUtils.encode(watermarkId);

        List<XWPFParagraph> paragraphs = document.getParagraphs();

        for (XWPFParagraph paragraph : paragraphs) {

            List<XWPFRun> runs = paragraph.getRuns();
            for (XWPFRun characterRun : runs) {
                String text = characterRun.text();
                if (text.length()<minTextLength){
                    continue;
                }

                String handleText = handleText(text,invisibleWatermark);

                characterRun.setText(handleText,0);
            }
        }

        // 保存文档
        try (FileOutputStream fos = new FileOutputStream(outputFilePath)) {
            document.write(fos);
        }

        System.out.println("Hidden text added to the Word document.");
    }

    private static void read(String targetFilePath) throws Exception{

        XWPFDocument document = new XWPFDocument(new FileInputStream(targetFilePath));
        List<XWPFParagraph> paragraphList = document.getParagraphs();
        XWPFParagraph paragraph = paragraphList.get(0);
        System.out.println("水印内容："+TextDarkUtils.decode(paragraph.getText()));

    }

    private static String handleText(String text,String insertStr){
        StringBuilder finalText = new StringBuilder();

        if (text.length() < minTextLength){
            return text;
        }

        if (text.length()<maxTextLength){
            int centerIndex = text.length() / 2;
            finalText.append(text,0,centerIndex).append(insertStr).append(text,centerIndex,text.length());
            return finalText.toString();
        }

        // 创建一个集合来存储标点符号
        List<String> textList = splitText(text);

        int textLength = 0;

        for (int i = 0; i < textList.size(); i++) {
            String str = textList.get(i);
            textLength += str.length();
            if (str.length()< maxTextLength*2 && textLength >= maxTextLength) {
                int centerIndex = str.length() / 2;
                finalText.append(str,0,centerIndex).append(insertStr).append(str,centerIndex,str.length());
            } else if (str.length() >= maxTextLength){
                for (int j = 0; j < str.length(); j+=maxTextLength) {
                    if (j + maxTextLength < str.length()){
                        finalText.append(str, j,j+maxTextLength).append(insertStr);
                    }else{
                        finalText.append(str, j,str.length());
                    }
                }
            }else if (str.length() <= minTextLength){
                finalText.append(str);
                continue;
            }else if (str.length() > minTextLength){
                finalText.append(str).append(insertStr);
            }

            textLength = 0;
        }
        return finalText.toString();
    }

    public static List<String> splitText(String text){
        // 创建一个集合来存储标点符号
        List<String> textList = new ArrayList<>();
        char[] chars = text.toCharArray();
        int tempIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            if (isPunctuation(chars[i])) {
                String substring = text.substring(tempIndex, i);
                if (substring.length() > 0) {
                    textList.add(substring);
                }
                textList.add(String.valueOf(chars[i]));
                tempIndex = i + 1;
            }else if (i == chars.length-1){
                String substring = text.substring(tempIndex, i+1);
                if (substring.length() > 0) {
                    textList.add(substring);
                }
            }
        }
        return textList;
    }

    public static boolean isPunctuation(char c) {
        // 使用Character类的isLetterOrDigit方法判断字符是否是字母或数字
        // 如果不是字母或数字，则可能是标点符号
        return ' ' == c || (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c));
    }

}
