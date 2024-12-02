package test.study.java.mianshiti2024;

import java.util.Arrays;
import java.util.List;

/**
 * @author sun yang
 * @date 2024/11/4
 */
public class Test1104 {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("2", "c", "A", "佛们", "波", "啊啊", "啊波");
        strings.sort(StringUtils::compare2);
        strings.forEach(System.out::println);
    }

}
