package test.study.java.mianshiti2024;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author sun yang
 * @date 2024/3/4
 */
public class Test0304 {

    public static void main(String[] args) {
        String input = "zhong1chong3";

        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String firstPair = matcher.group();
            System.out.println(firstPair);
        }
    }

}
