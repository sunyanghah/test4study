package test.study.news.web;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;

import java.io.File;
import java.io.UnsupportedEncodingException;

/**
 * Created by dell on 2019/8/28.
 * @author dell
 */
public class MyTest10 {

    public static void main(String[] args){
        String str = "abcdefg";
        String substring = str.substring(2, 5);
        System.out.println(substring.length() +"-------"+ (5-2));
//        test2();
    }

    private static void test1(){
        String jarWholePath = MyTest10.class.getProtectionDomain().getCodeSource().getLocation().getFile();
        try {
            jarWholePath = java.net.URLDecoder.decode(jarWholePath, "UTF-8");
        } catch (UnsupportedEncodingException e) { System.out.println(e.toString()); }
        String jarPath = new File(jarWholePath).getParentFile().getAbsolutePath();
        System.out.println(jarPath);
    }

    private static void test2(){
        int i = 5;
        System.out.println(i+=(i++)-i-(i-++i));
    }


}
