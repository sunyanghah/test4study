package test.study.java.mianshiti2021;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author sunYang
 * @Date 2021-03-19
 */
public class Test0319 {

    private static Pattern pattern = Pattern.compile(".*\\[(.*)\\].*");

    public static void main(String[] args) {

        String str = "cardNo [ 123, 1231, ggg ] is exists";

//        String str = "o1231to";

        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            System.out.println(matcher.group(1));
        }

        try {
            test1();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void test1() throws Exception {
        String str = null;
        if (str == null) {
            throw new Exception("ssssss");
        }
    }

}
