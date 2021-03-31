package test.study.news.web;


import com.alibaba.fastjson.JSON;

import java.math.BigDecimal;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dell on 2019/7/3.
 * @author dell
 */
public class MyTest3 {
//2958325248   3958325248
    public static void main(String[] args) throws Exception{
        Double usePercent = new BigDecimal("10").divide(new BigDecimal("3"),2,BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(usePercent);


        String str = "{\"startTime\":\"2019-07-01 23:13:41\",\"runTime\":\"1天7 时17分7秒\"}";
        Map<String,String> map = JSON.parseObject(str,Map.class);
        System.out.println(map.get("startTime"));
    }

    private static Pattern pattern = Pattern.compile("load average:(.+)(?:\\n|\\s+|$)");
    private static void test1() throws Exception{
        String str = "top - 23:48:18 up 1 day, 34 min,  4 users,  load average: 0.00, 0.01, 0.05\n";
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            String matchStr = matcher.group(1);
            String[] lordArr = matchStr.replaceAll(" ", "").split(",");
            for (String s : lordArr) {
                System.out.println(s);
            }
        }
    }

    private static Pattern patternCpu = Pattern.compile("ni, (.+?) id,");
    private static void test2() throws Exception{
        String str = "%Cpu(s):  0.0 us,  0.2 sy,  0.0 ni, 99.8 id,  0.0 wa,  0.0 hi,  0.0 si,  0.0 st";
        Matcher matcher = patternCpu.matcher(str);
        if (matcher.find()){
            System.out.println(matcher.group(1));
        }
    }

}
