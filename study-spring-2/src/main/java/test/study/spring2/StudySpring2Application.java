package test.study.spring2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import test.study.spring2.service.TestProxyService;

/**
 * Created by dell on 2019/6/24.
 * @author dell
 */
@SpringBootApplication
public class StudySpring2Application {

    /**
     * spring boot 2 自动装配设置cglib为默认动态代理
     * https://www.cnblogs.com/coderxiaohei/p/11758239.html
     * @param args
     */
    public static void main(String[] args){
        ConfigurableApplicationContext run = SpringApplication.run(StudySpring2Application.class, args);
//        AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(StudySpring2Application.class);
//        TestProxyService bean = acac.getBean(TestProxyService.class);
//        bean.myPrint();
//        String[] beanDefinitionNames = acac.getBeanDefinitionNames();
//        for (String beanDefinitionName : beanDefinitionNames) {
//            if (beanDefinitionName.startsWith("my") || beanDefinitionName.startsWith("test.")) {
//                System.out.println(beanDefinitionName);
//            }
//        }
    }

}
