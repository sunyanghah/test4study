package test.study.java.mianshiti2022;

import org.springframework.util.StringUtils;

/**
 * @author sunYang
 * @date 2022/11/2 13:59
 */
public class Test1102 {

    public static void main(String[] args) {
        System.out.println(StringUtils.hasLength(" ")); // true
        System.out.println(StringUtils.hasText(" ")); // false
        System.out.println(org.apache.commons.lang3.StringUtils.isBlank(" ")); // true
        System.out.println(org.apache.commons.lang3.StringUtils.isEmpty(" ")); // false

        System.out.println("----");

        System.out.println(StringUtils.hasLength("")); // false
        System.out.println(StringUtils.hasText("")); // false
        System.out.println(org.apache.commons.lang3.StringUtils.isBlank("")); // true
        System.out.println(org.apache.commons.lang3.StringUtils.isEmpty("")); // true

        System.out.println("----");

        System.out.println(StringUtils.hasLength(null));
        System.out.println(StringUtils.hasText(null));
        System.out.println(org.apache.commons.lang3.StringUtils.isBlank(null));
        System.out.println(org.apache.commons.lang3.StringUtils.isEmpty(null));


        System.out.println("--------------");
        System.out.println(StringUtils.getFilename("/uinnova/test/a.txt"));
        System.out.println(StringUtils.pathEquals("/uinnova/test/a.txt", "/uinnova/test/a/b/../../a.txt")); // true
        System.out.println(StringUtils.pathEquals("/uinnova/test/a.txt", "/uinnova/test/./a.txt")); // true
        System.out.println(StringUtils.pathEquals("/uinnova/test/a.txt", "/uinnova/test/a/a.txt")); // false
    }

}
