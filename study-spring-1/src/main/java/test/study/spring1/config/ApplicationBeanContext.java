package test.study.spring1.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author sunYang
 * @Date 2021-03-26
 */
@Component
public class ApplicationBeanContext implements ApplicationContextAware {

    private static ApplicationContext applicationContext;
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationBeanContext.applicationContext = applicationContext;
    }


    public static <T> T getBean(String beanName,Class<T> clazz) {
        if (applicationContext.containsBean(beanName)) {
            return  clazz.cast(applicationContext.getBean(beanName));
        } else {
            return null;
        }
    }

}
