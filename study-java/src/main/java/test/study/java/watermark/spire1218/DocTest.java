package test.study.java.watermark.spire1218;

import com.spire.doc.Document;
import com.spire.doc.FileFormat;
import com.spire.doc.HeaderFooter;
import com.spire.doc.Section;
import com.spire.doc.documents.Paragraph;
import com.spire.doc.documents.ShapeLineStyle;
import com.spire.doc.documents.ShapeType;
import com.spire.doc.fields.ShapeObject;

import java.awt.*;

/**
 * @author sun yang
 * @date 2024/11/28
 */
public class DocTest {

    public static void main(String[] args) throws Exception {

        //Load the sample document
        Document doc = new Document();
        doc.loadFromFile("F:\\watermark\\spire\\doc.doc");
        //Add WordArt shape and set the size
        ShapeObject shape = new ShapeObject(doc, ShapeType.Text_Plain_Text);
        shape.setWidth(60);
        shape.setHeight(20);
        //Set the text, position and sytle for the wordart
        shape.setVerticalPosition(30);
        shape.setHorizontalPosition(20);
        shape.setRotation(315);
        shape.getWordArt().setFontFamily("宋体"); // 设置字体
        shape.getWordArt().setText("这是doc水印\n第二行\n第三行");
//        shape.setFillColor(Color.red);
//        shape.setFillTransparency(0.1);
        shape.setLineStyle(ShapeLineStyle.Single);
        shape.setStrokeColor(new Color(197, 195, 197, 2));
        shape.setStrokeWeight(1);

        Section section;
        HeaderFooter header;
        for (int n = 0; n < doc.getSections().getCount(); n++) {
            section = doc.getSections().get(n);
            //Get the header of section
            header = section.getHeadersFooters().getHeader();
            Paragraph paragraph1;
            for (int i = 0; i < 4; i++) {
                //Add the hearder to the paragraph
                paragraph1 = header.addParagraph();
                for (int j = 0; j < 3; j++) {
                    //copy the word are and add it to many places
                    shape = (ShapeObject) shape.deepClone();
                    shape.setVerticalPosition(50 + 150 * i);
                    shape.setHorizontalPosition(20 + 160 * j);
                    paragraph1.getChildObjects().add(shape);
                }
            }
        }
        //Save the document to file
        doc.saveToFile("F:\\watermark\\spire\\result\\doc.doc", FileFormat.Doc);

    }

}
