package test.study.spring1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import test.study.spring1.dto.BeanTest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sunYang
 * @Date 2020/10/9
 */
@Configuration
public class BeanTestConfig {

    public static final String BEAN1 = "bean1";
    public static final String BEAN2 = "bean2";
    public static final String BEAN3 = "bean3";


    @Bean(name = {BEAN1})
    public BeanTest testBean1(){
        BeanTest bean = new BeanTest();
        bean.setName("name111");
        bean.setAddress("addr111");
        bean.setAge(11);
        return bean;
    }

    @Bean(name = {BEAN2})
    @Resource(name = BEAN1)
    public Map testbean1(BeanTest bean1){
        Map map = new HashMap();
        map.put("address",bean1.getAddress());
        return map;
    }

    @Bean(name = {BEAN3})
    @Resource(name = BEAN1)
    public BeanTest testBean3(BeanTest bean1){
        bean1.setAddress("addr333");
        bean1.setAge(33);
        return bean1;
    }

}
