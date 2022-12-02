package test.socket2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by dell on 2018/11/22.
 * @author dell
 */
@SpringBootApplication(scanBasePackages = {"test.socket2"})
public class TestSocket2Application {
    public static void main(String[] args){
        SpringApplication.run(TestSocket2Application.class,args);
    }
}
