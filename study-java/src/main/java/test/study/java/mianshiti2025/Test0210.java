package test.study.java.mianshiti2025;

import java.util.Arrays;

/**
 * @author sun yang
 * @date 2025/2/10
 */
public class Test0210 {

    public static void main(String[] args) {
        String fileName = "test.xls";
        System.out.println(!Arrays.asList("xlsx", "xls").contains(fileName.substring(fileName.lastIndexOf(".") + 1)));
    }
}
