package test.study.java.mianshiti2022;

import java.math.BigDecimal;

/**
 * @author sunYang
 * @date 2022/3/15 16:25
 */
public class Test0315 {

    public static void main(String[] args) {
        String stationFlowValue = "3";
        String thresholdValue = "10";
        String s = new BigDecimal(stationFlowValue).divide(new BigDecimal(thresholdValue)).multiply(new BigDecimal("100")).setScale(0, BigDecimal.ROUND_HALF_UP).toString();
        System.out.println(s);
    }

}
