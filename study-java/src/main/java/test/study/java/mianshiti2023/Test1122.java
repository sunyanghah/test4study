package test.study.java.mianshiti2023;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;

public class Test1122 {

    public static void main(String[] args) {
        HashMap<String, String> userMap = new HashMap<>();
        // 添加键值对到HashMap
        userMap.put("huangyazhou", "hyz@DSWS");
        userMap.put("jituo", "jt@DSWS");
        userMap.put("yanzelin", "yzl@DSWS");
        userMap.put("zuojianchun", "zjc@DSWS");
        userMap.put("lupengcheng", "lpc@DSWS");
        userMap.put("weixiaoqiang", "wxq@DSWS");
        userMap.put("shangzhijie", "szj@DSWS");
        userMap.put("sunyang", "sy@DSWS");
        userMap.put("wushaoqing", "wsq@DSWS");
        userMap.put("jiangdongqiu", "jdq@DSWS");
        userMap.put("tianxinchao", "txc@DSWS");
        userMap.put("yuanminmin","ymm@DSWS");

        System.out.printf(JSON.toJSONString(userMap));

    }

}
