package test.study.java.decorator;

import com.alibaba.fastjson.JSON;

import java.util.Map;

/**
 * @author sun yang
 * @date 2023/11/27
 */
public class Test {

    public static void main(String[] args) {
        test2();
    }

    public static void test2(){
        Map<String, Object> config = StrategyBuilder.create()
                .withAll()
                .getConfig();

        System.out.println(JSON.toJSONString(config));
    }

}
