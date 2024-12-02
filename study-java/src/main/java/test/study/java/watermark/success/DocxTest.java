package test.study.java.watermark.success;

import com.spire.doc.Document;
import com.spire.doc.FileFormat;
import com.spire.doc.HeaderFooter;
import com.spire.doc.Section;
import com.spire.doc.documents.Paragraph;
import com.spire.doc.documents.TextWrappingStyle;
import com.spire.doc.fields.DocPicture;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * @author sun yang
 * @date 2024/11/28
 */
public class DocxTest {

    public static void main(String[] args) throws Exception {


        ByteArrayOutputStream outputStream = addToDocx(new FileInputStream("F:\\watermark\\success\\docx.docx"),
                new String[]{"这是docx水印", "第二行", "第三行"},
                16,
                "#FF0000",
                20,
                45);

        outputStream.writeTo(new FileOutputStream("F:\\watermark\\success\\result\\docx.docx"));

    }

    public static ByteArrayOutputStream addToDocx(InputStream inputStream, String[] textArr,
                                                 int fontSize, String fontColor, int opacity, int rotate) throws Exception {

        //Load the sample file
        Document doc = new Document();
        doc.loadFromStream(inputStream, FileFormat.Docx);
        //Load the image
        DocPicture picture = new DocPicture(doc);

        byte[] imageBytes = WatermarkUtil.createSingleWaterMarkOfBytes(WatermarkUtil.transText(textArr),
                100, 100,
                WatermarkUtil.hexStringToColor(fontColor,opacity)
                , new Font("微软雅黑", Font.BOLD, fontSize),rotate);

        picture.loadImage(imageBytes);

        //Set the text wrapping style
        picture.setTextWrappingStyle(TextWrappingStyle.Behind);

        for (int n = 0; n < doc.getSections().getCount(); n++) {
            Section section = doc.getSections().get(n);
            //Get the head of section
            HeaderFooter header = section.getHeadersFooters().getHeader();
            Paragraph paragrapg1;
            if(header.getParagraphs().getCount()>0){
                paragrapg1=header.getParagraphs().get(0);

            }else {
                //Add the header to the paragraph
                paragrapg1 = header.addParagraph();
            }

            for (int p = 0; p < 5; p++) {

                for (int q = 0; q < 3; q++) {
                    //copy the image and add it to many places
                    picture = (DocPicture)picture.deepClone();
                    picture.setVerticalPosition(50 + 150 * p);
                    picture.setHorizontalPosition(20 + 160 * q);
                    paragrapg1.getChildObjects().add(picture);
                }
            }
        }

        //Save the document to inputStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        doc.saveToFile(outputStream, FileFormat.Docx);

        return outputStream;
    }

}
