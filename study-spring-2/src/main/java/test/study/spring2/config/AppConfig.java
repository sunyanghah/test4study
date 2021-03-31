package test.study.spring2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import test.study.spring2.bean.MyImportSelector;
import test.study.spring2.bean.MyTestBean1;

/**
 * Created by dell on 2020/5/18.
 * @author dell
 */
@ComponentScan("test.study.spring2")
@Import(MyImportSelector.class)
@Configuration
public class AppConfig {

    @Bean
    public MyTestBean1 myTestBean1(){
        return new MyTestBean1();
    }

//    @Bean
//    public UrlBasedViewResolver urlBasedViewResolver(){
//        return new UrlBasedViewResolver();
//    }

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver(){
        return new InternalResourceViewResolver("/",".jsp");
    }

}
