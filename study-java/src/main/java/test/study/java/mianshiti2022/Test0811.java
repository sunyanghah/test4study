package test.study.java.mianshiti2022;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author sunYang
 * @date 2022/8/11 15:14
 */
public class Test0811 {

    public static void main(String[] args) throws Exception{
        File file = new File("H:/test.txt");
        FileOutputStream fos = null;
        file.createNewFile();
        fos = new FileOutputStream(file);
        fos.write("mmmmmmmmmmmmmmmmmmmm".getBytes());
        fos.flush();
        fos.close();
    }

}
