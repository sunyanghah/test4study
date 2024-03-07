package test.study.spring1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import test.study.spring1.factorybean.TestFactoryBeanService;
import test.study.spring1.service.TestProxy;

/**
 * Created by dell on 2019/6/24.
 * @author dell
 */
@SpringBootApplication
public class StudySpring1Application {

    public static void main(String[] args){
        ConfigurableApplicationContext run = SpringApplication.run(StudySpring1Application.class, args);
//        AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(StudySpring1Application.class);
//        TestProxy bean = acac.getBean(TestProxy.class);
//        bean.myPrint();

        TestFactoryBeanService bean = run.getBean(TestFactoryBeanService.class);
        bean.test();

    }

}
