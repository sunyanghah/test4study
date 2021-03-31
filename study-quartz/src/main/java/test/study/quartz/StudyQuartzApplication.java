package test.study.quartz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by dell on 2019/11/6.
 * @author dell
 */
@SpringBootApplication(scanBasePackages = {"test.study.quartz"})
public class StudyQuartzApplication {
    public static void main(String[] args){
        SpringApplication.run(StudyQuartzApplication.class,args);
    }
}
