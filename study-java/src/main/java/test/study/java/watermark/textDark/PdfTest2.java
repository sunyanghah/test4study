package test.study.java.watermark.textDark;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author sun yang
 * @date 2024/12/31
 */
public class PdfTest2 {

    public static void main(String[] args) throws IOException {
        // 输入和输出文件路径
        String inputFilePath = "F:\\watermark\\textDark\\pdf.pdf";  // 输入 PDF 文件路径
        String outputFilePath = "F:\\watermark\\textDark\\result\\pdf.pdf"; // 输出 PDF 文件路径

        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        PDFont font = PDType0Font.load(document, new File("D:\\IDEA\\gitWork\\test4study\\study-java\\src\\main\\java\\test\\study\\java\\mianshiti2024\\STSONG.TTF"));
        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        contentStream.beginText();
        contentStream.setFont(font, 12);
        contentStream.newLineAtOffset(100, 700); // 设置文本位置
        contentStream.showText("这是中文哈哈哈哈哈");
        contentStream.endText();
        contentStream.close();

        document.save(new File(outputFilePath));
        document.close();
    }


}
