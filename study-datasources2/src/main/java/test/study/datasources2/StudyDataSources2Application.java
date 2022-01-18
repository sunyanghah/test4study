package test.study.datasources2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Created by dell on 2019/6/24.
 * @author dell
 */
@SpringBootApplication
@EnableConfigurationProperties
public class StudyDataSources2Application {

    public static void main(String[] args){
        SpringApplication.run(StudyDataSources2Application.class, args);
    }

}
