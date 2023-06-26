package study.slowsql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by dell on 2019/11/6.
 * @author dell
 */
@SpringBootApplication(scanBasePackages = {"study.slowsql"})
public class StudySlowsqlApplication {
    public static void main(String[] args){
        SpringApplication.run(StudySlowsqlApplication.class,args);
    }
}
