package test.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by dell on 2018/11/22.
 * @author dell
 */
@SpringBootApplication(scanBasePackages = {"test.webflux"})
public class TestWebfluxApplication {
    public static void main(String[] args){
        SpringApplication.run(TestWebfluxApplication.class,args);
    }
}