package test.stomp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Created by dell on 2018/11/22.
 * @author dell
 */
@EnableConfigurationProperties
@SpringBootApplication(scanBasePackages = {"test.stomp"})
public class TestStompApplication {
    public static void main(String[] args){
        SpringApplication.run(TestStompApplication.class,args);
    }
}
