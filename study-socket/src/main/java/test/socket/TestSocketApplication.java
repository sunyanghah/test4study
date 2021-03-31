package test.socket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by dell on 2018/11/22.
 * @author dell
 */
@SpringBootApplication(scanBasePackages = {"test.socket"})
public class TestSocketApplication {
    public static void main(String[] args){
        SpringApplication.run(TestSocketApplication.class,args);
    }
}
