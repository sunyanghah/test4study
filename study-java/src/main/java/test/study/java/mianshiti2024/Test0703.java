package test.study.java.mianshiti2024;

import org.apache.commons.lang3.StringUtils;

/**
 * @author sun yang
 * @date 2024/7/3
 */
public class Test0703 {

    public static void main(String[] args) throws Exception{

        int size = 1024*1024*1024*2;
        System.out.println(size);

        System.out.println(handleAcCode("ND5RCYEHVALN828NJ8QH44WURG6WWSE"));

    }

    private static String handleAcCode(String acCode){
        if (StringUtils.isBlank(acCode) || acCode.length() != 31){
            return acCode;
        }

        StringBuilder acCodeFormat = new StringBuilder(acCode.substring(0, 2))
                .append("-").append(acCode, 2, 6)
                .append("-").append(acCode, 6, 11)
                .append("-").append(acCode, 11, 16)
                .append("-").append(acCode, 16, 21)
                .append("-").append(acCode, 21, 26)
                .append("-").append(acCode, 26, 31);


        return acCodeFormat.toString();
    }

}
