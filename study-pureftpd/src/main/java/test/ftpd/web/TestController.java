package test.ftpd.web;

import lombok.var;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.PrintWriter;
import java.util.HashMap;

/**
 * @author sunYang
 * @date 2022/7/25 17:47
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public void test() throws Exception{

        FTPClient ftp = new FTPClient();
        ftp.setControlEncoding("UTF-8");
        ftp.addProtocolCommandListener(new PrintCommandListener(
                new PrintWriter(System.out)));
        ftp.connect("82.156.172.114",21);
        ftp.login("nevEm","nevEm");
        ftp.setFileType(FTP.BINARY_FILE_TYPE);
        ftp.enterLocalPassiveMode();

        FTPFile[] ftpFiles = ftp.listFiles();
        for (FTPFile ftpFile : ftpFiles) {
            System.out.println("--------"+ftpFile.getName());
            if (FTPFile.DIRECTORY_TYPE == ftpFile.getType()){
                FTPFile[] ftpFiles2 = ftp.listFiles(ftpFile.getName());
                for (FTPFile file : ftpFiles2) {
                    System.out.println("--------"+file.getName());
                }
            }
        }

    }

}
