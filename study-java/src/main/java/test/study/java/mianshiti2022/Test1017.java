package test.study.java.mianshiti2022;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author sunYang
 * @date 2022/10/17 18:25
 */
public class Test1017 {

    public static void main(String[] args) {
        String path = Test1017.getFilePath("ttt-1.0.2.zip");
        System.out.println("path:"+path);
        File file = new File(path);
        if(file.exists() && file.isFile()){
            try {
                InputStream inputStream = new FileInputStream(file);
                System.out.println(inputStream);
            } catch (Exception e) {
                System.err.println("解析文件"+file.getName()+"异常：");
                e.printStackTrace();
            }
        }

    }

    public static String getFilePath(String fileName){
        return Test1017.class.getResource(fileName).getPath();
    }

}
