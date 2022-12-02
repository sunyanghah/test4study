package test.study.java.mianshiti2022;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * @author sunYang
 * @date 2022/7/28 10:37
 */
public class Test0728 {

    public static void main(String[] args) throws Exception{

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("H:/test.txt"))));

        try(BufferedWriter bw1 = bw) {
            bw1.write("112233");
            bw1.flush();
        }

        while (true){}

    }

}


