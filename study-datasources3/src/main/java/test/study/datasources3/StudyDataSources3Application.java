package test.study.datasources3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Created by dell on 2019/6/24.
 * @author dell
 */
@EnableConfigurationProperties
@SpringBootApplication(scanBasePackages = {"test.study.datasources3"})
public class StudyDataSources3Application {

    public static void main(String[] args){
        SpringApplication.run(StudyDataSources3Application.class, args);
    }

}
