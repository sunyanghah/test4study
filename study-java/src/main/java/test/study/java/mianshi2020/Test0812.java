package test.study.java.mianshi2020;

import java.util.regex.Pattern;

/**
 * @author sunYang
 * @Date 2020/8/12
 */
public class Test0812 {

    public static void main(String[] args) {
        System.out.println(Pattern.matches("^1\\d{10}", "11302231131"));

        System.out.println(Pattern.matches("[1|0]","3"));

    }

}
