package test.study.java.mianshiti2022;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.google.gson.Gson;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sunYang
 * @date 2022/11/23 18:58
 */
public class Test1123 {

    public static void main(String[] args) {

        Gson gson = new Gson();

        JSONArray serialsArray = new JSONArray();
        serialsArray.addAll(Arrays.asList(1,2,3));

        Timestamp t = new Timestamp(System.currentTimeMillis());

        HashMap<String, Object> closeEventInfo = new HashMap<>(5);
        closeEventInfo.put("Serial", "webCloseSerial");
        closeEventInfo.put("webCloseSerials", serialsArray);
        closeEventInfo.put("CloseInfo", "close");
        closeEventInfo.put("CloseUID", "uId");
        closeEventInfo.put("closeTime", t);
        closeEventInfo.put("Status", "2");
        Notification eventClose = new Notification("closeEvent", closeEventInfo);

        String obj = new Gson().toJson(eventClose);

        System.out.println(obj);

//        Notification notification = gson.fromJson(obj, Notification.class);
        Map o = gson.fromJson(obj, Map.class);

        Notification notification = JSON.parseObject(obj, Notification.class);
        HashMap hm = (HashMap) notification.getContent();
        System.out.println("end");
    }

}
