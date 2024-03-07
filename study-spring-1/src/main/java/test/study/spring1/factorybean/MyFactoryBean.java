package test.study.spring1.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author sunyang
 * @date 2023-11-02
 * @desc
 */
@Component
public class MyFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return new TestFactoryBeanServiceImpl();
    }

    @Override
    public Class<?> getObjectType() {
        return TestFactoryBeanService.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
