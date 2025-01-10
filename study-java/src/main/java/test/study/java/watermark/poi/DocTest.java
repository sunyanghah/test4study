package test.study.java.watermark.poi;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.hwpf.converter.WordToHtmlUtils;
import org.apache.poi.hwpf.usermodel.HeaderStories;
import org.apache.poi.hwpf.usermodel.Picture;
import org.apache.poi.hwpf.usermodel.Range;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

/**
 * @author sun yang
 * @date 2024/12/26
 */
public class DocTest {

    public static void main(String[] args) {

        String inputFilePath = "F:\\watermark\\poi\\doc.doc";
        String outputFilePath = "F:\\watermark\\poi\\result\\doc.html";

        try (FileInputStream fis = new FileInputStream(inputFilePath)) {
            HWPFDocument document = new HWPFDocument(fis);

            // 创建 HTML 转换器
            WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(
                    DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument()
            );

            // 将 Word 转换为 HTML DOM
            wordToHtmlConverter.processDocument(document);

            // 提取图片并保存
            List<Picture> pictures = document.getPicturesTable().getAllPictures();
            if (pictures != null) {
                for (Picture pic : pictures) {
                    String imageFileName = "image" + pic.suggestFullFileName();
                    File imageFile = new File(imageFileName);
                    try (FileOutputStream fos = new FileOutputStream(imageFile)) {
                        fos.write(pic.getContent());
                    }
                }
            }

            // 转换 DOM 为 HTML
            Document htmlDocument = wordToHtmlConverter.getDocument();
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "html");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            DOMSource domSource = new DOMSource(htmlDocument);
            StreamResult streamResult = new StreamResult(new File(outputFilePath));

            // 输出 HTML 文件
            transformer.transform(domSource, streamResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
