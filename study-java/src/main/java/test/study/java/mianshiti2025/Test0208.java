package test.study.java.mianshiti2025;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sun yang
 * @date 2025/2/8
 */
public class Test0208 {

    public static void main(String[] args) {
        String text = "你好，世界！这是一个@#测试：看看,有.多少标&点符号？";

        // 创建一个集合来存储标点符号
        Set<Character> punctuations = new HashSet<>();

        // 遍历字符串中的每个字符
        for (char c : text.toCharArray()) {
            if (isPunctuation(c)) {
                System.out.println("找到标点符号: " + c);
            }
        }
    }

    // 判断字符是否是标点符号
    public static boolean isPunctuation(char c) {
        // 使用Character类的isLetterOrDigit方法判断字符是否是字母或数字
        // 如果不是字母或数字，则可能是标点符号
        return !Character.isLetterOrDigit(c) && !Character.isWhitespace(c);
    }

}
