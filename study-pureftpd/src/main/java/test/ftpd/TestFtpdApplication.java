package test.ftpd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by dell on 2018/11/22.
 * @author dell
 */
@SpringBootApplication(scanBasePackages = {"test.ftpd"})
public class TestFtpdApplication {
    public static void main(String[] args){
        SpringApplication.run(TestFtpdApplication.class,args);
    }
}
