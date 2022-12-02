package test.tonglink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by dell on 2018/11/22.
 * @author dell
 */
@EnableConfigurationProperties
@SpringBootApplication(scanBasePackages = {"test.tonglink"})
@EnableScheduling
public class TestTonglinkApplication {
    public static void main(String[] args){
        SpringApplication.run(TestTonglinkApplication.class,args);
    }

}
