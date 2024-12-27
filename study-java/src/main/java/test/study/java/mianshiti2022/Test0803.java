package test.study.java.mianshiti2022;

import java.util.Arrays;
import java.util.List;

/**
 * @author sunYang
 * @date 2022/8/3 14:03
 */
public class Test0803 {

    private static List<String> fileTypeList = Arrays.asList("exe", "pkg", "dmg","deb","rpm","tt");

    public static void main(String[] args) {
        String name = "abc.tt";
        System.out.println(name.substring(name.lastIndexOf(".")+1));
        if (!fileTypeList.contains(name.substring(name.lastIndexOf(".")+1))) {
            System.out.println("文件格式错误");
        }
    }

}
