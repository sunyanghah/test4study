package test.study.java.watermark.test1202;

import com.spire.doc.*;
import com.spire.doc.documents.Paragraph;
import com.spire.doc.documents.ShapeLineStyle;
import com.spire.doc.documents.ShapeType;
import com.spire.doc.documents.TextWrappingStyle;
import com.spire.doc.fields.DocPicture;
import com.spire.doc.fields.ShapeObject;

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


        ByteArrayOutputStream outputStream = addToDoc(new FileInputStream("F:\\watermark\\success\\docx.docx"),
                new String[]{"这是docx水印", "第二行", "第三行"},
                14,
                "#FF0000",
                30,
                90);

        outputStream.writeTo(new FileOutputStream("F:\\watermark\\success\\result\\docx.docx"));

    }

    public static ByteArrayOutputStream addToDoc(InputStream inputStream, String[] textArr,
                                                 int fontSize,String fontColor,int opacity,int rotate) throws Exception {

        //Load the sample file
        Document doc = new Document();
        doc.loadFromStream(inputStream, FileFormat.Docx);
        //Load the image
        DocPicture picture = new DocPicture(doc);

        Font font = new Font("微软雅黑", Font.PLAIN, fontSize);
        int imageSize = WatermarkUtil.calculateSize(textArr, font, rotate);

        byte[] imageBytes = WatermarkUtil.createSingleWaterMarkOfBytes(WatermarkUtil.transText(textArr),
                imageSize, imageSize,
                WatermarkUtil.hexStringToColor(fontColor,opacity)
                ,font ,rotate);

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

            int spaceWidth = 100;
            int spaceHeight = 150;

            int x = -20;
            int y = 50;

            PageSetup pageSetup = doc.getSections().get(0).getPageSetup();
            float clientWidth = pageSetup.getClientWidth();
            int widthNum = (int)(clientWidth / imageSize) + 1;

            float clientHeight = pageSetup.getClientHeight();
            int heightNum = (int)(clientHeight / imageSize) + 1;

            for (int p = 0; p < heightNum; p++) {

                int verticalPosition = y;
                for (int q = 0; q < widthNum; q++) {
                    //copy the image and add it to many places
                    picture = (DocPicture)picture.deepClone();
                    picture.setVerticalPosition(verticalPosition);
                    picture.setHorizontalPosition(x);
                    paragrapg1.getChildObjects().add(picture);

                    verticalPosition += imageSize + spaceHeight;
                }

                x += imageSize + spaceWidth;

            }
        }

        //Save the document to inputStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        doc.saveToFile(outputStream, FileFormat.Docx);

        return outputStream;
    }


}