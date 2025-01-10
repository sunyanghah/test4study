package test.study.java.watermark.textDark;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

/**
 * @author sun yang
 * @date 2024/12/31
 */
public class PdfTest {

    public static void main(String[] args) throws IOException {
        // 输入和输出文件路径
        String inputFilePath = "F:\\watermark\\textDark\\pdf2.pdf";  // 输入 PDF 文件路径
        String outputFilePath = "F:\\watermark\\textDark\\result\\pdf2.pdf"; // 输出 PDF 文件路径

        try {
            PDDocument document = PDDocument.load(new File(inputFilePath));
            PDFTextStripper pdfStripper = new PDFTextStripper();
            String text = pdfStripper.getText(document);
            // 替换
            String newText = text + "123";

            PDFont font = PDType0Font.load(document, new File("D:\\IDEA\\gitWork\\test4study\\study-java\\src\\main\\java\\test\\study\\java\\mianshiti2024\\simfang.ttf"));

            // 更新 PDF 页面
            for (PDPage page : document.getPages()) {

                PDPageContentStream contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true);
                contentStream.beginText();
                contentStream.setFont(font, 12);
                contentStream.newLineAtOffset(100, 700); // 设置文本位置
                contentStream.showText(newText);
                contentStream.endText();
                contentStream.close();
            }
            document.save(new File(outputFilePath));
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
