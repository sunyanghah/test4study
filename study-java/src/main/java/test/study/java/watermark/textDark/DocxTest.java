package test.study.java.watermark.textDark;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

/**
 * @author sun yang
 * @date 2024/12/30
 */
public class DocxTest {

    public static void main(String[] args) throws Exception{

        String inputFilePath = "F:\\watermark\\textDark\\docx.docx";
        String outputFilePath = "F:\\watermark\\textDark\\result\\docx.docx";

        add(inputFilePath,outputFilePath);
        read(outputFilePath);

    }

    private static void add(String inputFilePath,String outputFilePath) throws Exception{
        // 创建一个新的 Word 文档
        XWPFDocument document = new XWPFDocument(new FileInputStream(inputFilePath));

        // 创建一个段落
        List<XWPFParagraph> paragraphList = document.getParagraphs();

        XWPFParagraph paragraph = paragraphList.get(0);

        // 在文档开头插入不可见字符（例如零宽度空格）
        String invisibleWatermark =  TextDarkUtils.encode(123L);

        // 创建一个运行（文字片段）
        XWPFRun run = paragraph.insertNewRun(1);
        run.setText(invisibleWatermark);

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

}
