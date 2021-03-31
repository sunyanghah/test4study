package test.study.spring2.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

/**
 * Created by dell on 2020/5/18.
 * @author dell
 */
public class MyWebApplicationInitializer implements WebApplicationInitializer {

    // servlet 3.0 之后提出的一个新规范 SPI
    // "你（spring）"的项目里面如果有某些类或者某些方法 需要在启动的时候被web容器调用的话
    // 首先需要你在你的项目根目录的META-INF/services 目录下建立一个文件 spring-web包下META-INF/services/javax.servlet.ServletContainerInitializer
    @Override
    public void onStartup(ServletContext servletCxt) {

        // Load Spring web application configuration
        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
        ac.register(AppConfig.class);
        ac.refresh();

        // Create and register the DispatcherServlet
        DispatcherServlet servlet = new DispatcherServlet(ac);
        ServletRegistration.Dynamic registration = servletCxt.addServlet("app", servlet);
        registration.setLoadOnStartup(1);
    }
}