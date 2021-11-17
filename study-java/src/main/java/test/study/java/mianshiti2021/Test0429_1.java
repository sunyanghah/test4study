package test.study.java.mianshiti2021;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sunYang
 * @Description:
 * @Title: Test0429
 * @Package test.study.java.mianshiti2021
 * @date 2021-04-2918:53
 */
public class Test0429_1 {


    public static void main(String[] args) {

        SysPriceRuleDetail.PriceRuleStep s1 = new SysPriceRuleDetail.PriceRuleStep();
        s1.setStartMile("81");
        s1.setEndMile("100");
        s1.setPrice("3.5");

        SysPriceRuleDetail.PriceRuleStep s2 = new SysPriceRuleDetail.PriceRuleStep();
        s2.setStartMile("51");
        s2.setEndMile("80");
        s2.setPrice("4");

        SysPriceRuleDetail.PriceRuleStep s3 = new SysPriceRuleDetail.PriceRuleStep();
        s3.setStartMile("26");
        s3.setEndMile("50");
        s3.setPrice("4.5");

        SysPriceRuleDetail.PriceRuleStep s4 = new SysPriceRuleDetail.PriceRuleStep();
        s4.setStartMile("6");
        s4.setEndMile("25");
        s4.setPrice("5");

        List<SysPriceRuleDetail.PriceRuleStep> stepList = Arrays.asList(s4, s3, s2, s1);


        List<SysPriceRuleDetail> sysPriceRuleDetails = handlePriceRule("5","100",
                stepList,"10","20");

        String str = JSON.toJSONString(sysPriceRuleDetails);

        System.out.println(str);
//
//        JSONArray jsonArray = JSON.parseArray(str);
//
//        System.out.println(jsonArray.get(0).toString());
//
//        System.out.println(jsonArray.get(jsonArray.size() - 1).toString());
//
//        List<Object> steps = jsonArray.subList(1, jsonArray.size() - 1);
//
//        System.out.println(steps);


    }

    public static List<SysPriceRuleDetail> handlePriceRule(String baseKm,String baseMoney,
                                                    List<SysPriceRuleDetail.PriceRuleStep> stepList,
                                                    String lowerLimit,String upperLimit){

        SysPriceRuleDetail.PriceBase base = new SysPriceRuleDetail.PriceBase();
        base.setStartMile("0");
        base.setEndMile(baseKm);
        base.setTotalPrice(baseMoney);
        base.setExpression("x-x+"+base.getTotalPrice());

        for (int i = 0; i < stepList.size(); i++) {

            SysPriceRuleDetail.PriceRuleStep step = stepList.get(i);

            LinkedList<SysPriceRuleDetail.PriceRuleStep> linkedList = new LinkedList<>(stepList.subList(0, i));
            String str = handleExpression(linkedList, new BigDecimal(base.getEndMile()));

            BigDecimal subtract = new BigDecimal(step.getStartMile()).subtract(BigDecimal.ONE);
            String thisExpression = new StringBuilder("(x-").append(subtract).append(")*")
                    .append(step.getPrice()).toString();

            step.setExpression(thisExpression+str+"+"+base.getTotalPrice());

        }

        SysPriceRuleDetail.PriceRuleLimit limit = new SysPriceRuleDetail.PriceRuleLimit();
        limit.setLowerLimit(lowerLimit);
        limit.setUpperLimit(upperLimit);

        List<SysPriceRuleDetail> ruleList = new ArrayList<>();
        ruleList.add(base);
        ruleList.addAll(stepList);
        ruleList.add(limit);

        return ruleList;
    }


    private static String handleExpression(LinkedList<SysPriceRuleDetail.PriceRuleStep> stepList, BigDecimal endMile){


        // 拿出第一个
        SysPriceRuleDetail.PriceRuleStep prevStep = stepList.pollFirst();

        if (prevStep == null){
            return "";
        }

        // 本级step的开始公里数
        BigDecimal startM = new BigDecimal(prevStep.getStartMile());

        // 如果开始公里数等于了起步价的结束公里数，说明是firstStep就返回
        if (endMile.add(BigDecimal.ONE).compareTo(startM) != 0){
            throw new RuntimeException("CommonResultCode.ERROR_PRICE_RULE.getMsg()");
        }

        // 上一个step的基本信息
        BigDecimal prevStartM = new BigDecimal(prevStep.getStartMile()).subtract(BigDecimal.ONE);
        BigDecimal prevEndM = new BigDecimal(prevStep.getEndMile());

        // 生成上一个step的表达式，因为本级要有变量
        String prevSubMile = prevEndM.subtract(prevStartM).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        String prevExpression = new StringBuilder(prevSubMile).append("*").append(prevStep.getPrice()).toString();

        endMile = new BigDecimal(prevStep.getEndMile());

        // 上一个step的表达式 + 递归执行
        return   handleExpression(stepList,endMile) + "+" + prevExpression;

    }

    @Data
    public static class SysPriceRuleDetail implements Serializable {

        @Data
        public static class PriceBase extends SysPriceRuleDetail{

            private String startMile;

            private String endMile;

            private String totalPrice;

            private String expression;
        }


        @Data
        public static class PriceRuleStep extends SysPriceRuleDetail{

            private String startMile;

            private String endMile;

            private String price;

            private String expression;

        }

        @Data
        public static class PriceRuleLimit extends SysPriceRuleDetail{

            private String upperLimit;

            private String lowerLimit;

        }

    }

}