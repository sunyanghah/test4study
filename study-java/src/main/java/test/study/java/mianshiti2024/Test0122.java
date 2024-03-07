package test.study.java.mianshiti2024;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author sun yang
 * @date 2024/1/22
 */
public class Test0122 {

    public static void main(String[] args) {
        Set<String> primarySet = new HashSet<>();
        primarySet.add("1");
        primarySet.add("2");
        primarySet.add("3");
        primarySet.add("4");

        primarySet.stream().collect(Collectors.toMap(s -> s, s -> true));

    }

}
