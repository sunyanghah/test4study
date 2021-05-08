package test.study.java.mianshiti2021;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author sunYang
 * @Date 2021-04-23
 */
public class Test0423 {

    public static void main(String[] args) {
        String str = "{\"baseKm\":\"3\",\"baseMoney\":\"14\",\"lowerLimit\":\"10%\",\"stepList\":[{\"endKm\":\"5\",\"price\":\"1\",\"startKm\":\"1\"},{\"endKm\":\"10\",\"price\":\"2\",\"startKm\":\"5\"}],\"upperLimit\":\"5%\"}";

        SysPriceRuleDetail sysPriceRuleDetail = JSON.parseObject(str, SysPriceRuleDetail.class);

        System.out.println(")()()((((((((((((((((");


    }


    @Data
    public static class SysPriceRuleDetail implements Serializable {

        private String baseKm;

        private String baseMoney;

        private List<PriceRuleStep> stepList;

        private String upperLimit;

        private String lowerLimit;

        @Data
        public static class PriceRuleStep{

            private String startKm;

            private String endKm;

            private String price;

        }

    }

}
