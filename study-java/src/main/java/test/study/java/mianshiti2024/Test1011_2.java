package test.study.java.mianshiti2024;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author sun yang
 * @date 2024/10/11
 */
public class Test1011_2 {

    public static void main(String[] args) {

        long num = 360000;

        System.out.println(new BigDecimal(String.valueOf(num))
                .divide(new BigDecimal(3600000),1, RoundingMode.DOWN)
                .doubleValue());

    }

}
