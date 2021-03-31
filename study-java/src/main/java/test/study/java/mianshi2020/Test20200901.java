package test.study.java.mianshi2020;

import java.util.UUID;

/**
 * @author sunYang
 * @Date 2020/9/1
 */
public class Test20200901 {

    public static void main(String[] args) {
        System.out.println(System.getProperties().getProperty("os.name").contains("windows"));
        System.out.println(UUID.randomUUID().toString().replaceAll("-",""));
        String str = "1231223.jpg";
        System.out.println(str.substring(str.lastIndexOf(".")));
    }

}
