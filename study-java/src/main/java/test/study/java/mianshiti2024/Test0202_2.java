package test.study.java.mianshiti2024;

import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.io.IOUtils;

import java.io.*;

/**
 * @author sun yang
 * @date 2024/2/2
 */
public class Test0202_2 {

    public static void main(String[] args) throws Exception{
        String zipFilePath = "F:\\test\\metaspace-1.0.1001.16-std.alpha-x86.exe";
        String destDir = "F:\\test";

        test(zipFilePath,destDir);

    }

    public static void test(String exeFilePath,String outputDirectory) throws Exception{

        try (InputStream inputStream = new FileInputStream(exeFilePath);
             ArchiveInputStream archiveInputStream = new ArchiveStreamFactory().createArchiveInputStream(ArchiveStreamFactory.ZIP, inputStream)) {

            ArchiveEntry entry;
            while ((entry = archiveInputStream.getNextEntry()) != null) {
                if (!archiveInputStream.canReadEntryData(entry)) {
                    System.out.println("Skipped entry " + entry.getName() + " because the entry data could not be read");
                    continue;
                }

                String entryName = entry.getName();
                File outputFile = new File(outputDirectory, entryName);

                if (entry.isDirectory()) {
                    if (!outputFile.exists() && !outputFile.mkdirs()) {
                        throw new IOException("Could not create directory: " + outputFile);
                    }
                } else {
                    try (OutputStream outputStream = new FileOutputStream(outputFile)) {
                        IOUtils.copy(archiveInputStream, outputStream);
                    }
                }
            }

            System.out.println("Successfully extracted exe file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
