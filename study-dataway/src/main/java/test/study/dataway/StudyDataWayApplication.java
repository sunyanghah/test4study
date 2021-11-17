package test.study.dataway;

import net.hasor.spring.boot.EnableHasor;
import net.hasor.spring.boot.EnableHasorWeb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by dell on 2019/6/24.
 * @author dell
 */
@SpringBootApplication
@EnableHasor()
@EnableHasorWeb()
public class StudyDataWayApplication {

    public static void main(String[] args){
        SpringApplication.run(StudyDataWayApplication.class, args);
    }

}
