package test.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by dell on 2018/11/22.
 * @author dell
 */
@SpringBootApplication(scanBasePackages = {"test.rabbitmq"})
public class TestRabbitmqApplication {
    public static void main(String[] args){
        SpringApplication.run(TestRabbitmqApplication.class,args);
    }
}
