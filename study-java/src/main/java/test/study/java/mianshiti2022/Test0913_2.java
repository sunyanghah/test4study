package test.study.java.mianshiti2022;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * @author sunYang
 * @date 2022/9/13 10:21
 */
public class Test0913_2 {

    public static void main(String[] args) throws Exception{

        File file = new File("H:\\xxv\\ttt-1.0.2.zip");

        ZipInputStream zis = new ZipInputStream(new FileInputStream(file));

        ZipEntry zipEntry;

        byte[] bytes = null;

        while ((zipEntry = zis.getNextEntry()) != null){
            if ("resources/preview2.png".equalsIgnoreCase(zipEntry.getName())){
                bytes = new byte[zis.available()];
                zis.read(bytes);
            };
        }

        File targetFile = new File("H:/xxv/test0914.png");
        if (!targetFile.exists()){
            targetFile.createNewFile();
        }

        FileOutputStream fileOutputStream = new FileOutputStream(targetFile);
        fileOutputStream.write(bytes);
        fileOutputStream.flush();
        fileOutputStream.close();
        System.out.println(bytes);

    }

}
