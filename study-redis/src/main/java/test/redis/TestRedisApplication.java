package test.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by dell on 2018/11/22.
 * @author dell
 */
@SpringBootApplication(scanBasePackages = {"test.redis"})
public class TestRedisApplication {
    public static void main(String[] args){
        SpringApplication.run(TestRedisApplication.class,args);
    }
}