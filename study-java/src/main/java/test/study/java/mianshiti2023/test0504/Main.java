package test.study.java.mianshiti2023.test0504;

import com.alibaba.fastjson.JSON;

/**
 * @author sunYang
 * @date 2023/5/4 11:27
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(FatherClass.class.getInterfaces()));
        System.out.println(JSON.toJSONString(FatherInterface.class.getInterfaces()));
        System.out.println(JSON.toJSONString(Son1.class.getInterfaces()));
        System.out.println(JSON.toJSONString(Son2.class.getInterfaces()));
        System.out.println(JSON.toJSONString(Son3.class.getInterfaces()));
        System.out.println(JSON.toJSONString(FatherInterface3.class.getInterfaces()));
        System.out.println(JSON.toJSONString(Son4.class.getInterfaces()));
    }

}
