package test.tongweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by dell on 2018/11/22.
 * @author dell
 */
@EnableConfigurationProperties
@SpringBootApplication(scanBasePackages = {"test.tongweb"})
@EnableScheduling
public class TestWebApplication {
    public static void main(String[] args){
        SpringApplication.run(TestWebApplication.class,args);
    }

}
