package test.study.fastdfs.controller;

import org.csource.fastdfs.StorageClient1;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import test.study.fastdfs.config.FdfsConfig;
import test.study.fastdfs.config.FdfsConfigProperties;
import test.study.fastdfs.config.RP;

import javax.annotation.Resource;
import java.io.*;

/**
 * @author sunYang
 * @date 2022/7/6 10:10
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private StorageClient1 storageClient1;
    @Resource
    private FdfsConfigProperties fdfsConfigProperties;

    @GetMapping("/getFileContent")
    public RP getFileContent(@RequestParam("path")String path) throws Exception{

        byte[] bytes = storageClient1.download_file1(path);

        String content = new String(bytes);

        return RP.buildSuccess(content);
    }

    @GetMapping("/saveFileContent")
    public RP saveFileContent(@RequestParam("code")String code,@RequestParam("path")String path) throws Exception{

        int i = storageClient1.delete_file1(path);

        String newPath = storageClient1.upload_file1(code.getBytes(), "js", FdfsConfig.FDFS_EMPTY_META_LIST);

        return RP.buildSuccess(newPath);
    }

    public static byte[] file2byte(File file) {
        if (file == null) {
            return null;
        }
        FileInputStream fileInputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int n;
            while ((n = fileInputStream.read(b)) != -1) {
                byteArrayOutputStream.write(b, 0 , n);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
