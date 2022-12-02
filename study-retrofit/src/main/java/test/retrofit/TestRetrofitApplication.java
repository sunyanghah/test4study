package test.retrofit;

import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by dell on 2018/11/22.
 * @author dell
 */
@SpringBootApplication(scanBasePackages = {"test.retrofit"})
@RetrofitScan("test.retrofit.client")
public class TestRetrofitApplication {
    public static void main(String[] args){
        SpringApplication.run(TestRetrofitApplication.class,args);
    }
}
