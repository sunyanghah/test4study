package test.study.java.mianshiti2025;

import org.apache.commons.lang3.StringUtils;

/**
 * @author sun yang
 * @date 2025/1/17
 */
public class Test0117_2 {

    public static void main(String[] args) {
        String mobile = "+8612345678901";
        if (StringUtils.isNotBlank(mobile)){
            if (mobile.startsWith("+")){
                mobile = mobile.substring(0,6)+"****"+mobile.substring(10);
            }else {
                mobile = mobile.substring(0,3)+"****"+mobile.substring(7);
            }
        }
        System.out.println(mobile);
    }

}
