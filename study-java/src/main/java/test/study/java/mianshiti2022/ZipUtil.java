package test.study.java.mianshiti2022;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipUtil {

    private static final String TAG = "ZipUtil";

    /**
     * 解压文件到指定文件夹
     *
     * @param zipFile      源文件
     */
    public static void unzip(File zipFile, String destPath) {

        File destFolder = new File(destPath);
        if (!destFolder.exists()) {
            destFolder.mkdirs();
        }
        ZipInputStream zis = null;
        BufferedOutputStream bos = null;
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(zipFile);
            zis = new ZipInputStream(new BufferedInputStream(fis));
            ZipEntry ze;
            while ((ze = zis.getNextEntry()) != null) {
                //得到解压文件在当前存储的绝对路径
                String filePath = destPath + File.separator + ze.getName();
                if (ze.isDirectory()) {
                    new File(filePath).mkdirs();
                } else {
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    byte[] buffer = new byte[1024];
                    int count;
                    while ((count = zis.read(buffer)) != -1) {
                        baos.write(buffer, 0, count);
                    }
                    byte[] bytes = baos.toByteArray();
                    File entryFile = new File(filePath);
                    //创建父目录
                    if (!entryFile.getParentFile().exists()) {
                        if (!entryFile.getParentFile().mkdirs()) {
                            throw new FileNotFoundException("zip entry mkdirs is failed");
                        }
                    }
                    //写文件
                    fos = new FileOutputStream(entryFile);

                    bos = new BufferedOutputStream(fos);
                    bos.write(bytes);
                    bos.flush();
                    bos.close();
                    fos.close();
                    baos.close();
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try{
                if (zis != null){
                    zis.close();
                }
                if (bos != null){
                    bos.close();
                }
                if (fis != null){
                    fis.close();
                }
                if (fos != null){
                    fos.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }


    /**
     * 压缩文件夹成zip
     * @param srcDir 待打包的文件夹路径
     * @param out 打包文件名及存储路径
     * @param KeepDirStructure 是否保留文件夹结构 不保留则把文件夹下全部文件都打压在一起
     * @throws RuntimeException
     */
    public static void zip(String srcDir, OutputStream out, boolean KeepDirStructure)throws RuntimeException
    {
        ZipOutputStream zos = null ;
        try
        {
            zos = new ZipOutputStream(out);
            File sourceFile = new File(srcDir);
            compress(sourceFile,zos,sourceFile.getName(),true,KeepDirStructure);
        } catch (Exception e)
        {
            throw new RuntimeException("zip error from ZipUtils",e);
        }finally
        {
            if(zos != null)
            {
                try
                {
                    zos.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 压缩文件夹成zip
     * @param srcDir 待打包的文件夹路径
     * @param targetDir 打包文件名及存储路径
     * @param KeepDirStructure 是否保留文件夹结构 不保留则把文件夹下全部文件都打压在一起
     * @throws RuntimeException
     */
    public static void zip(String srcDir, String targetDir, boolean KeepDirStructure)throws RuntimeException
    {
        ZipOutputStream zos = null ;
        try
        {
            File targetFile = new File(targetDir);
            if (!targetFile.exists()){
                targetFile.getParentFile().mkdirs();
                targetFile.createNewFile();
            }
            zos = new ZipOutputStream(new FileOutputStream(targetFile));
            File sourceFile = new File(srcDir);
            compress(sourceFile,zos,sourceFile.getName(),true,KeepDirStructure);
        } catch (Exception e)
        {
            throw new RuntimeException("zip error from ZipUtils",e);
        }finally
        {
            if(zos != null)
            {
                try
                {
                    zos.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 递归压缩方法
     * @param sourceFile 源文件
     * @param zos     zip输出流
     * @param name     压缩后的名称
     * @param rootFlag 是否是根
     * @param KeepDirStructure 是否保留原来的目录结构,true:保留目录结构;
     *               false:所有文件跑到压缩包根目录下(注意：不保留目录结构可能会出现同名文件,会压缩失败)
     * @throws Exception
     */
    private static void compress(File sourceFile, ZipOutputStream zos, String name,boolean rootFlag,
                                 boolean KeepDirStructure) throws Exception
    {
        int BUFFER_SIZE = 2 * 1024;
        byte[] buf = new byte[BUFFER_SIZE];
        if(sourceFile.isFile())
        {
            // 向zip输出流中添加一个zip实体，构造器中name为zip实体的文件的名字
            zos.putNextEntry(new ZipEntry(name));
            // copy文件到zip输出流中
            int len;
            FileInputStream in = new FileInputStream(sourceFile);
            while ((len = in.read(buf)) != -1)
            {
                zos.write(buf, 0, len);
            }
            // Complete the entry
            zos.closeEntry();
            in.close();
        } else
        {
            File[] listFiles = sourceFile.listFiles();
            if(listFiles == null || listFiles.length == 0)
            {
                // 需要保留原来的文件结构时,需要对空文件夹进行处理
                if(KeepDirStructure)
                {
                    // 空文件夹的处理
                    zos.putNextEntry(new ZipEntry(name + "/"));
                    // 没有文件，不需要文件的copy
                    zos.closeEntry();
                }
            }else {
                for (File file : listFiles)
                {
                    // 判断是否需要保留原来的文件结构
                    if (KeepDirStructure)
                    {
                        // 注意：file.getName()前面需要带上父文件夹的名字加一斜杠,
                        // 不然最后压缩包中就不能保留原来的文件结构,即：所有文件都跑到压缩包根目录下了

                        String path = "";
                        if (rootFlag){
                            path = file.getName();
                        }else{
                            path = name + "/" + file.getName();
                        }

                        compress(file, zos, path,false, KeepDirStructure);
                    } else
                    {
                        compress(file, zos, file.getName(),false,KeepDirStructure);
                    }
                }
            }
        }
    }


}

