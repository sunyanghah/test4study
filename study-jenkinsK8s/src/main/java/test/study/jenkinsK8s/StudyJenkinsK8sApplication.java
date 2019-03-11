package test.study.jenkinsK8s;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by dell on 2018/11/22.
 * @author dell
 */
@SpringBootApplication(scanBasePackages = {"test.study"})
public class StudyJenkinsK8sApplication {
    public static void main(String[] args){
        SpringApplication.run(StudyJenkinsK8sApplication.class,args);
    }
}
