package test.study.java.mianshiti2022;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.Data;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sunYang
 * @date 2022/11/11 10:17
 */
public class Test1111 {

    public static void main(String[] args) throws Exception{
        JSONObject jo = new JSONObject();
//        jo.put("d1", "2022-11-08 14:022:25");
        jo.put("d2", "2022-11-08");
        jo.put("d3", "2022-11-08 14:22:25");
        System.out.println("d1:" + jo.getTimestamp("d1"));
        System.out.println("d2:" + jo.getTimestamp("d2"));
        System.out.println("d3:" + jo.getTimestamp("d3"));

        System.out.println("---------");
        Ttt ttt = new Ttt();
        ttt.setName("ddd");
        ttt.setTimestamp(new Timestamp(System.currentTimeMillis()));

        Map map = new HashMap<>();
        map.put("eventInfo", JSON.parseObject(JSON.toJSONString(ttt)));
        map.put("state","1");

        String s = new Gson().toJson(map);
        Map map1 = new Gson().fromJson(s, Map.class);

        JSONObject jsonObject = new JSONObject(map1);
        System.out.println(jsonObject.getJSONObject("eventInfo").getTimestamp("timestamp"));
    }


    @Data
    public static class Ttt{

        private String name;

        private Timestamp timestamp;
    }


}
