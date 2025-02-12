package test.study.java.watermark.textDark;

import com.ibm.icu.text.CharsetDetector;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sun yang
 * @date 2025/2/12
 */
public class CsvTest {

    public static void main(String[] args) throws Exception{
        String inputFilePath = "F:\\watermark\\textDark\\csv.csv";
        String outputFilePath = "F:\\watermark\\textDark\\result\\csv.csv";

        addContentDark(inputFilePath, outputFilePath);
        read(outputFilePath);
    }

    private static String getFileCharset(String filePath) throws Exception{
        CharsetDetector detector = new CharsetDetector();
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath))){
            detector.setText(bis);
            return detector.detect().getName();
        }
    }

    private static void addContentDark(String inputFilePath, String outputFilePath) throws Exception{

        CSVReader reader;
        try{
            reader = new CSVReader(new InputStreamReader(new FileInputStream(inputFilePath),getFileCharset(inputFilePath)));
        }catch (FileNotFoundException e){
            System.out.println("文件找不到");
            e.printStackTrace();
            return;
        }

        CSVWriter writer = new CSVWriter(new FileWriter(outputFilePath));
        String invisibleWatermark =  TextDarkUtils.encode(123L);

        String[] line;
        while ((line = reader.readNext()) != null) {
            List<String> newLine = new ArrayList<>();
            for (String str : line) {
                if (StringUtils.isBlank(str)) {
                    continue;
                }
                int pos = str.length()/2;
                String newString = str.substring(0, pos) + invisibleWatermark + str.substring(pos);
                newLine.add(newString);
            }
            writer.writeNext(newLine.toArray(new String[0]));
            writer.flush();
        }

        reader.close();
        writer.flush();
        writer.close();
    }

    private static void read(String outputFilePath) throws Exception{
        CSVReader reader;
        try {
            reader = new CSVReader(new InputStreamReader(new FileInputStream(outputFilePath),getFileCharset(outputFilePath)));
        }catch (FileNotFoundException e){
            System.out.println("文件找不到");
            e.printStackTrace();
            return;
        }

        String[] line;
        while ((line = reader.readNext()) != null) {
            for (String str : line) {
                if (StringUtils.isBlank(str)) {
                    continue;
                }
                Long decode = TextDarkUtils.decode(str);
                if (decode != null) {
                    System.out.println("水印内容："+decode);
                    return;
                }
            }
        }

    }

}
