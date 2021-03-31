package test.study.observation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by dell on 2018/11/22.
 * @author dell
 */
@SpringBootApplication(scanBasePackages = {"test.study.observation"})
public class StudyObservationApplication {
    public static void main(String[] args){
        SpringApplication.run(StudyObservationApplication.class,args);
    }
}
