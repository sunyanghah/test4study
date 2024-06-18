package test.study.java.mianshiti2024;

import java.util.regex.Pattern;

/**
 * @author sun yang
 * @date 2024/4/9
 */
public class Test0409 {

    public static void main(String[] args) {

        String str = "10.21.20.22";

        System.out.println(isDomain(str));
        System.out.println(isPort(str));
    }

    private static boolean isDomain(String s) {
        // 简单的域名正则表达式（不适用于所有情况，但适用于大多数）
        String domainRegex = "^([a-zA-Z0-9]([a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?\\.)+[a-zA-Z]{2,}$";
        return Pattern.matches(domainRegex, s);
    }


    private static boolean isPort(String s) {
        // 正则表达式匹配端口号
        String portRegex = "\\:\\d+";
        return Pattern.compile(portRegex).matcher(s).find();
    }

}
