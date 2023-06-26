package study.slowsql2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Created by dell on 2019/11/6.
 * @author dell
 */
@SpringBootApplication(scanBasePackages = {"study.slowsql2"})
@ServletComponentScan
public class StudySlowsql2Application {
    public static void main(String[] args){
        SpringApplication.run(StudySlowsql2Application.class,args);
    }
}
