package test.study.java.mianshiti2024;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author sun yang
 * @date 2024/3/11
 */
public class Test0311 {

    public static String getExeFileVersion(File exeFile) {
        try {
            InputStream input = new FileInputStream(exeFile);
            Parser parser = new AutoDetectParser();
            BodyContentHandler handler = new BodyContentHandler();
            Metadata metadata = new Metadata();
            ParseContext context = new ParseContext();

            parser.parse(input, handler, metadata, context);

            return metadata.get("VersionNumber");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        File exeFile = new File("E:\\谷歌浏览器下载文件夹\\metaspace-1.0.1001.18-std.alpha-x86.exe");
        String version = getExeFileVersion(exeFile);
        System.out.println("Version number of the exe file is: " + version);
    }

}

