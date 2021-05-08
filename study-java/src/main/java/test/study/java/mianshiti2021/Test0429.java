package test.study.java.mianshiti2021;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sunYang
 * @Description:
 * @Title: Test0429
 * @Package test.study.java.mianshiti2021
 * @date 2021-04-2918:53
 */
public class Test0429 {


    public static void main(String[] args) {

        SysPriceRuleDetail.PriceRuleStep s1 = new SysPriceRuleDetail.PriceRuleStep();
        s1.setStartMile("80");
        s1.setEndMile("100");
        s1.setPrice("3.5");

        SysPriceRuleDetail.PriceRuleStep s2 = new SysPriceRuleDetail.PriceRuleStep();
        s2.setStartMile("50");
        s2.setEndMile("80");
        s2.setPrice("4");

        SysPriceRuleDetail.PriceRuleStep s3 = new SysPriceRuleDetail.PriceRuleStep();
        s3.setStartMile("25");
        s3.setEndMile("50");
        s3.setPrice("4.5");

        SysPriceRuleDetail.PriceRuleStep s4 = new SysPriceRuleDetail.PriceRuleStep();
        s4.setStartMile("5");
        s4.setEndMile("25");
        s4.setPrice("5");

        List<SysPriceRuleDetail> list = new ArrayList<>();

        SysPriceRuleDetail.PriceBase base = new SysPriceRuleDetail.PriceBase();
        base.setStartMile("0");
        base.setEndMile("5");
        base.setTotalPrice("100");
        base.setExpression("x-x+"+base.getTotalPrice());
        list.add(base);

        List<SysPriceRuleDetail.PriceRuleStep> stepList = Arrays.asList(s4, s3, s2, s1);

        stepList.forEach(step -> {
            String str = handleExpression(step, stepList, new BigDecimal("5"));
            step.setExpression("(x-" + step.getStartMile() + ")*" + step.getPrice() + "+" + str + "100");
        });

        list.addAll(stepList);

        SysPriceRuleDetail.PriceRuleLimit limit = new SysPriceRuleDetail.PriceRuleLimit();
        limit.setLowerLimit("10");
        limit.setUpperLimit("20");

        list.add(limit);

        String str = JSON.toJSONString(list);

        System.out.println(str);

        JSONArray jsonArray = JSON.parseArray(str);

        System.out.println(jsonArray.get(0).toString());

        System.out.println(jsonArray.get(jsonArray.size() - 1).toString());

        List<Object> steps = jsonArray.subList(1, jsonArray.size() - 1);

        System.out.println(steps);


    }


    private static String handleExpression(SysPriceRuleDetail.PriceRuleStep step, List<SysPriceRuleDetail.PriceRuleStep> stepList, BigDecimal endMile){
        // 本级step的开始公里数
        BigDecimal startM = new BigDecimal(step.getStartMile());

        // 根据本级的开始去找上级step，规则为 本step的开始公里数等于上一个step的结束公里数
        // 找不到就返回null
        SysPriceRuleDetail.PriceRuleStep prevStep = stepList.stream().filter(other -> {
            BigDecimal otherEm = new BigDecimal(other.getEndMile());
            if (otherEm.compareTo(startM) == 0) {
                return true;
            }
            return false;
        }).findFirst().orElse(null);

        // 如果开始公里数等于了起步价的结束公里数，说明是firstStep就返回
        if (startM.compareTo(endMile) == 0){
            return "";
        }
        // 如果开始公里数不等于结束公里数，并且不是firstStep，说明规则有问题
        if (prevStep == null){
            throw new RuntimeException("规则有问题");
        }
        // 上一个step的基本信息
        BigDecimal prevStartM = new BigDecimal(prevStep.getStartMile());
        BigDecimal prevEndM = new BigDecimal(prevStep.getEndMile());

        // 生成上一个step的表达式，因为本级要有变量
        String prevSubMile = prevEndM.subtract(prevStartM).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        String prevExpression = new StringBuilder(prevSubMile).append("*").append(prevStep.getPrice()).toString();
        // 上一个step的表达式 + 递归执行
        return prevExpression + "+" + handleExpression(prevStep,stepList,endMile);

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