package study.cdp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Created by dell on 2018/11/22.
 * @author dell
 */
@SpringBootApplication(scanBasePackages = {"study.cdp"})
public class TestCdpApplication {
    public static void main(String[] args){
        SpringApplication.run(TestCdpApplication.class,args);
    }
}
