package test.study.news;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by dell on 2018/11/22.
 * @author dell
 */
@SpringBootApplication(scanBasePackages = {"test.study.news"})
@MapperScan(value = {"test.study.news.mapper"})
public class StudyNewsApplication {
    public static void main(String[] args){
        SpringApplication.run(StudyNewsApplication.class,args);
    }
}
