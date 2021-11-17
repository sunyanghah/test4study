package test.schedule;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by dell on 2018/11/22.
 * @author dell
 */
@EnableScheduling
@SpringBootApplication
public class TestScheduleApplication {
    public static void main(String[] args){
        SpringApplication.run(TestScheduleApplication.class,args);
    }
}
