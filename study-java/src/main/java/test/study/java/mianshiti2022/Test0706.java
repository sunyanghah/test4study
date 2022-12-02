package test.study.java.mianshiti2022;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author sunYang
 * @date 2022/7/6 16:02
 */
public class Test0706 {

    public static void main(String[] args) throws Exception{
        File file = new File("H:\\1125\\a.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write("bbbb".getBytes());
        fileOutputStream.flush();
        fileOutputStream.close();
    }

}
