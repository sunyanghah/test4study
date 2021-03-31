package study.mysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by dell on 2019/11/6.
 * @author dell
 */
@SpringBootApplication(scanBasePackages = {"study.mysql"})
public class StudyMysqlApplication {
    public static void main(String[] args){
        SpringApplication.run(StudyMysqlApplication.class,args);
    }
}
