package test.study.fastdfs.controller;

import org.apache.commons.io.FilenameUtils;
import org.csource.common.MyException;
import org.csource.fastdfs.StorageClient1;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import test.study.fastdfs.config.*;
import test.study.fastdfs.dto.DevelopmentValue;
import test.study.fastdfs.dto.InTestDto;

import javax.annotation.Resource;
import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.zip.ZipInputStream;

/**
 * @author sunYang
 * @date 2022/7/4 15:26
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @Resource
    private StorageClient1 storageClient1;

    @Resource
    private IdGenerator idGenerator;

    @Resource
    private FdfsConfigProperties fdfsConfigProperties;

    private static int BUFFER = 1024;

    /**
     * 上传文件
     *
     * @param file
     * @description:
     * @author: sunYang
     * @return: com.logistics.nev.platform.common.core.ApiResult<java.lang.String>
     * @date: 2021-05-25 9:40
     */
    @PostMapping("/upload")
    public RP<Long> upload(MultipartFile file) throws IOException, MyException {

        if (file == null) {
            return RP.buildSuccess(null);
        }

        String originalFilename = file.getOriginalFilename();

        String extension = FilenameUtils.getExtension(originalFilename);

        final String filePath = storageClient1.upload_appender_file1(file.getBytes(),
                extension,
                FdfsConfig.FDFS_EMPTY_META_LIST);

        return RP.buildSuccess(filePath);
    }


    @PostMapping("/test")
    public RP test(@RequestBody InTestDto dto) throws Exception {

        String path = "C:/xxv/online_tool/staticResource"+File.separator+"demo"+File.separator+221;



        return RP.buildSuccess(null);
    }

    private void handleFileConstruct(Long pid, List<DevelopmentValue> developmentValueList, File file, Long developmentId) throws Exception{
        File[] files = file.listFiles();
        for (File f : files) {
            Long valueId = idGenerator.nextLong();

            DevelopmentValue developmentValue = DevelopmentValue.builder()
                    .id(valueId)
                    .developmentId(developmentId)
                    .name(f.getName())
                    .pid(pid)
                    .state(1)
                    .build();

            if(f.isDirectory()){
                developmentValue.setType(DevelopmentValueTypeE.FOLDER.getCode());
                developmentValueList.add(developmentValue);
                handleFileConstruct(valueId,developmentValueList,f,developmentId);
            }else {
                String path = upload(f);
                developmentValue.setFilePath(path);
                developmentValue.setType(DevelopmentValueTypeE.FILE.getCode());
                developmentValueList.add(developmentValue);
            }
        }
    }

    public String upload(File file) throws IOException, MyException {

        if (file == null) {
            return null;
        }

        String originalFilename = file.getName();

        String extension = FilenameUtils.getExtension(originalFilename);

        final String filePath = storageClient1.upload_file1(file2byte(file),
                extension,
                FdfsConfig.FDFS_EMPTY_META_LIST);

        return filePath;
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
