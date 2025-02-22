package test.stomp2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by dell on 2018/11/22.
 * @author dell
 */
@EnableConfigurationProperties
@SpringBootApplication(scanBasePackages = {"test.stomp2"})
@EnableScheduling
public class TestStomp2Application {
    public static void main(String[] args){
        SpringApplication.run(TestStomp2Application.class,args);
    }
}
