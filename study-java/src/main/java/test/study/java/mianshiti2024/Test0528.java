package test.study.java.mianshiti2024;

/**
 * @author sun yang
 * @date 2024/5/28
 */
public class Test0528 {


    public static void main(String[] args) {
        String str = "trustworkspace.exe            6324 Console                    4    174,064 K";

        String[] split = str.split("\\s+");
        System.out.println(split[1]+"---"+split[1].length());

    }
}
