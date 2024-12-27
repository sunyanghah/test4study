package test.study.java.watermark.split;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author sun yang
 * @date 2024/12/25
 */
public class DocAppend {

    public static void main(String[] args) {

    }

    public static void splitWordByParagraph22(String inputFilePath, String outputDirectory) throws Exception{
        try (FileInputStream fis = new FileInputStream(inputFilePath)) {

            HWPFDocument document = new HWPFDocument(fis);
            Range range = document.getRange();

            range.insertAfter(range.getParagraph(0).text());

            Paragraph first = range.getParagraph(0);
            first.delete();
            document.write(new FileOutputStream(outputDirectory+"last.doc"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fis = new FileInputStream(inputFilePath)) {

            HWPFDocument document = new HWPFDocument(fis);
            Range range = document.getRange();
            int numParagraphs = range.numParagraphs();

            for (int i = 1; i < numParagraphs; i++) {
                range.getParagraph(i).delete();
            }

            document.write(new FileOutputStream(outputDirectory+"first.doc"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
