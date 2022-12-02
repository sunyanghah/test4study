package test.study.java.mianshiti2022;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @author sunYang
 * @date 2022/9/13 10:21
 */
public class Test0913 {

    public static void main(String[] args) throws Exception{

        File file = new File("H:\\xxv\\ttt-1.0.2.zip");

        String tempDirectoryPath = FileUtils.getTempDirectoryPath()+File.separator+"ttt-1.0.2";
        ZipUtil.unzip(file,tempDirectoryPath);

        File resources = new File(tempDirectoryPath + File.separator+"resources");
        if (!resources.exists()){
            resources.mkdir();
        }

        File preview = new File(resources.getAbsolutePath() + File.separator + "preview.png");

        FileInputStream fis = new FileInputStream(new File("H:\\图片\\3333.png"));

        FileOutputStream outputStream = new FileOutputStream(preview);

        //写入压缩文件
        int len;
        byte[] buffer = new byte[1024]; //字节数组大小可调节
        //读取fis字节流，转移到buffer字节数组中去，读取后fis为空
        while ((len = fis.read(buffer)) > 0) {
            outputStream.write(buffer, 0, len);
        }
        fis.close();
        outputStream.flush();
        outputStream.close();

        ZipUtil.zip(tempDirectoryPath,file.getAbsolutePath() ,true);

        FileUtils.deleteDirectory(new File(tempDirectoryPath));
    }

}
