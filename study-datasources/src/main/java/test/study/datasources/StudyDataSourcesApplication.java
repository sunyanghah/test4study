package test.study.datasources;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Created by dell on 2019/6/24.
 * @author dell
 */
@SpringBootApplication
@EnableConfigurationProperties
public class StudyDataSourcesApplication {

    public static void main(String[] args){
        SpringApplication.run(StudyDataSourcesApplication.class, args);
    }

}
