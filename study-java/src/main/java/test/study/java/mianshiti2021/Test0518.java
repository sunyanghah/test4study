package test.study.java.mianshiti2021;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.zip.GZIPInputStream;

/**
 * @author sunYang
 * @Description:
 * @Title: Test0518
 * @Package test.study.java.mianshiti2021
 * @date 2021-05-1811:04
 */
public class Test0518 {

    public static void main(String[] args) throws URISyntaxException {

        test3("D:/银河创想/绿配/msg_file/2021051717.gz");
    }


    private static void test1(){
        String str = "D:/银河创想/绿配/msg_file/a.txt";

        File file = new File(str);

        System.out.println(file);
        System.out.println("---");

        System.out.println(file.toPath());

        System.out.println("========");
        Instant instant = Instant.now().minus(2, ChronoUnit.HOURS);

        System.out.println(instant.atZone(ZoneId.systemDefault()));

        System.out.println("******************");
        Date timestamp = new Date();
        Instant instant2 = Instant.ofEpochMilli(timestamp.getTime()).plus(1, ChronoUnit.HOURS);
        System.out.println(instant2);
    }

    private static void test2(){
        Instant now = Instant.now();

        Instant instant = LocalDateTime.of(2021, 5, 17, 18, 00).toInstant(ZoneOffset.of("+8"));

        System.out.println(now);
        System.out.println(instant);

        long hours = Duration.between(instant, now).toHours();
        System.out.println(hours);


    }

    public static void test3(String sourcedir) {
        try {
            //建立gzip压缩文件输入流
            FileInputStream fin = new FileInputStream(sourcedir);
            //建立gzip解压工作流
            GZIPInputStream gzin = new GZIPInputStream(fin);

            BufferedReader br = new BufferedReader(new InputStreamReader(gzin));
            String str;
            while ((str = br.readLine()) != null){
                System.out.println(str);
                System.out.println("---");
            }

            gzin.close();
            br.close();
            fin.close();
        } catch (Exception ex){
            System.err.println(ex.toString());
        }
    }

}