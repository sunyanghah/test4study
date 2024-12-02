package test.study.java.mianshiti2024;

import java.util.Arrays;
import java.util.List;

/**
 * @author sun yang
 * @date 2024/9/12
 */
public class Test0912 {

    public static void main(String[] args) {

        List<String> strings = Arrays.asList("a", "b", "c");

        StringBuilder sb = new StringBuilder();

        for (String string : strings) {
            sb.insert(0, string+">");
        }

        System.out.println(sb.toString());

        String str = "";

        for (String string : strings) {
            str = string+">"+str;
        }
        System.out.println(str);
    }

}
