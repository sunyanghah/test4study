package test.study.java.mianshi2020;

import java.util.Optional;

/**
 * Created by dell on 2020/7/23.
 * @author dell
 */
public class Test0723 {

    public static void main(String[] args) {
        String str = null;
        String a = Optional.ofNullable(str).filter(s -> s.startsWith("a")).map(s -> s.substring(1, 2)).orElse("a null");
        System.out.println(a);
    }

}
