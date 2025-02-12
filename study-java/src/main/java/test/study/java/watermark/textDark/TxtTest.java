package test.study.java.watermark.textDark;

import java.io.*;

/**
 * @author sun yang
 * @date 2025/2/12
 */
public class TxtTest {

    public static void main(String[] args) throws Exception{
        String inputFilePath = "F:\\watermark\\textDark\\txt.txt";
        String outputFilePath = "F:\\watermark\\textDark\\result\\txt.txt";

        addContentDark(inputFilePath, outputFilePath);
        read(outputFilePath);
    }

    private static void addContentDark(String inputFilePath, String outputFilePath) throws Exception{
        BufferedReader br = null;
        try {
            //读取文件
            br = new BufferedReader(new FileReader(inputFilePath));
        }catch (FileNotFoundException e){
            System.out.println("文件找不到");
            e.printStackTrace();
            return;
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath));
        String invisibleWatermark =  TextDarkUtils.encode(123L);

        String str = br.readLine();
        while (str != null){
            int pos = str.length()/2;
            String newString = str.substring(0, pos) + invisibleWatermark + str.substring(pos);

            bw.write(newString);
            bw.newLine();
            str = br.readLine();
        }

        bw.flush();
        bw.close();
        br.close();

    }

    private static void read(String outputFilePath) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(outputFilePath));
        String str = br.readLine();
        while (str != null){
            Long decode = TextDarkUtils.decode(str);
            if (decode != null) {
                System.out.println("水印内容："+decode);
                break;
            }
            str = br.readLine();
        }
        br.close();
    }

}
