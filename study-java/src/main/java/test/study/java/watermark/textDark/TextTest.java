package test.study.java.watermark.textDark;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author sun yang
 * @date 2025/1/2
 */
public class TextTest {

    public static void main(String[] args) throws Exception{
        // 输入和输出文件路径
        String inputFilePath = "F:\\watermark\\textDark\\txt.txt";  // 输入文本文件路径
        String outputFilePath = "F:\\watermark\\textDark\\result\\txt.txt"; // 输出文本文件路径

        BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));

        String invisibleWatermark =  TextDarkUtils.encode(123L);

        String s = reader.readLine();
        while (s != null) {

            int pos = s.length()/2;
            String newString = s.substring(0, pos) + invisibleWatermark + s.substring(pos);

            writer.write(newString);
            writer.newLine();
            s = reader.readLine();
        }

        writer.flush();
        writer.close();
        reader.close();

    }

}
