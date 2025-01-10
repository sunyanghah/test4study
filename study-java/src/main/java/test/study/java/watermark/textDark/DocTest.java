package test.study.java.watermark.textDark;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.CharacterRun;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author sun yang
 * @date 2024/12/30
 */
public class DocTest {

    public static void main(String[] args) throws Exception{

        String inputFilePath = "F:\\watermark\\textDark\\doc.doc";
        String outputFilePath = "F:\\watermark\\textDark\\result\\doc.doc";

        add(inputFilePath,outputFilePath);
        read(outputFilePath);

    }

    private static void add(String inputFilePath,String outputFilePath) throws Exception{
        // 创建一个新的 Word 文档
        HWPFDocument document = new HWPFDocument(new FileInputStream(inputFilePath));

        Range range = document.getRange();

        // 在文档开头插入不可见字符（例如零宽度空格）
        String invisibleWatermark =  TextDarkUtils.encode(123L);

        int numParagraphs = range.numParagraphs();

        for (int i = 0; i < numParagraphs; i++) {
            Paragraph paragraph = range.getParagraph(i);

            int runNum = paragraph.numCharacterRuns();

            CharacterRun characterRun = paragraph.getCharacterRun(0);
            String text = characterRun.text();
            int pos = text.length() / 2;

            if (text.length() > 2) {
                if (text.endsWith("\r")) {
                    text = text.substring(0, text.length() - 1);
                }
                characterRun.replaceText(text, text+"1");
            }
        }

        // 保存文档
        try (FileOutputStream fos = new FileOutputStream(outputFilePath)) {
            document.write(fos);
        }

        System.out.println("Hidden text added to the Word document.");
    }

    private static void read(String targetFilePath) throws Exception{

        HWPFDocument document = new HWPFDocument(new FileInputStream(targetFilePath));
        Paragraph paragraph = document.getRange().getParagraph(0);
        System.out.println("水印内容："+TextDarkUtils.decode(paragraph.text()));

    }

}
