package test.stomp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by dell on 2018/11/22.
 * @author dell
 */
@SpringBootApplication(scanBasePackages = {"test.stomp"})
public class TestStompApplication {
    public static void main(String[] args){
        SpringApplication.run(TestStompApplication.class,args);
    }
}
