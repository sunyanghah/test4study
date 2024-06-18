package test.study.java.mianshiti2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author sun yang
 * @date 2024/4/1
 */
public class Test0401 {

    public static void main(String[] args) {

        System.out.println("+8615214206595".substring(3));

    }

    /**
     * 使用正则表达式统一格式化手机号为11位，去除国际区号。
     *
     * @param phoneNumber 可能包含国际区号的手机号
     * @return 统一格式的11位手机号，或者如果输入无效则返回null
     */
    public static String formatPhoneNumberWithRegex(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.length() < 11) {
            return null; // 输入的手机号为空或长度不足11位
        }

        // 正则表达式匹配国际区号和国家代码
        String internationalPrefix = "\\+?[0-9]{2}";
        Pattern pattern = Pattern.compile(internationalPrefix);
        Matcher matcher = pattern.matcher(phoneNumber);

        // 去除匹配到的国际区号和国家代码
        if (matcher.lookingAt()) {
            phoneNumber = phoneNumber.replaceFirst(internationalPrefix, "");
        }

        // 确保去除国际区号后的手机号长度为11位
        return phoneNumber.length() == 11 ? phoneNumber : null;
    }

}
