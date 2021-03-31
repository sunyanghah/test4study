package test.study.spring2.proxy;

import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author sunYang
 * @Date 2020/11/5
 */
@Component
public class DAO {

    @HikInterface(desc = "测试哈哈哈")
    public String tttt(String name, int age, Map map){
        return "4444444444444";
    }
}
