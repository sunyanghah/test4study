package test.study.java.watermark.split;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author sun yang
 * @date 2024/12/23
 */
public class DocSplit {

    public static void main(String[] args) throws Exception {

        splitWordByParagraph22("F:\\watermark\\split\\doc.doc", "F:\\watermark\\split\\split\\");

//        tt("F:\\watermark\\split\\split\\test.doc", "这是内容哈哈");
//        tt2("F:\\watermark\\split\\split\\test.doc");
    }

    public static void splitWordByParagraph22(String inputFilePath, String outputDirectory) throws Exception{
        try (FileInputStream fis = new FileInputStream(inputFilePath)) {

            HWPFDocument document = new HWPFDocument(fis);
            Range range = document.getRange();

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

    public static void splitWordByParagraph(String inputFilePath, String outputDirectory) throws Exception{
        try (FileInputStream fis = new FileInputStream(inputFilePath)) {

            HWPFDocument document = new HWPFDocument(fis);
            Range range = document.getRange();
            int numParagraphs = range.numParagraphs();

            Paragraph first = range.getParagraph(0);
            tt2(outputDirectory+"first.doc", first.text());

            StringBuilder sb = new StringBuilder();

            for (int i = 1; i < numParagraphs; i++) {
                Paragraph paragraph = range.getParagraph(i);
                sb.append(paragraph.text());
            }

            tt2(outputDirectory+"last.doc", sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void tt(String destFile,String fileContent) throws Exception{

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(fileContent.getBytes());

        POIFSFileSystem fileSystem = new POIFSFileSystem();

        DirectoryEntry directory = fileSystem.getRoot();

        directory.createDocument("WordDocument", byteArrayInputStream);

        FileOutputStream fileOutputStream = new FileOutputStream(destFile);

        fileSystem.writeFilesystem(fileOutputStream);

        byteArrayInputStream.close();

        fileOutputStream.close();
    }

    public static void tt2(String outputPath,String content){

        // 定义模板文件路径（可以是一个空白.doc文件）
        String templatePath = "F:\\watermark\\split\\temp\\temp.doc";

        try (FileInputStream fis = new FileInputStream(templatePath);
             HWPFDocument document = new HWPFDocument(fis)) {

            // 获取文档的范围
            Range range = document.getRange();

            // 向文档添加内容
            range.insertAfter(content);

            // 将文档写入到指定路径
            try (FileOutputStream out = new FileOutputStream(outputPath)) {
                document.write(out);
            }

            System.out.println("文档生成成功，路径：" + outputPath);
        } catch (IOException e) {
            System.err.println("生成文档时出错：" + e.getMessage());
        }
    }

}
