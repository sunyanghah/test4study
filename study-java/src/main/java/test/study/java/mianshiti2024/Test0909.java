package test.study.java.mianshiti2024;

import org.apache.commons.lang3.StringUtils;

/**
 * @author sun yang
 * @date 2024/9/9
 */
public class Test0909 {

    public static void main(String[] args) {
        String suVer = ""+3 + 100+ StringUtils.leftPad(String.valueOf(7),3,"0");
        System.out.println(suVer);
    }

}
