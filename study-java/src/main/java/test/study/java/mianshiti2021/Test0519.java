package test.study.java.mianshiti2021;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.time.Instant;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

/**
 * @author sunYang
 * @Description:
 * @Title: Test0519
 * @Package test.study.java.mianshiti2021
 * @date 2021-05-1910:47
 */
public class Test0519 {

    public static void main(String[] args) {
        test1();
    }

    private static void test(){
        Instant now = Instant.now();
        System.out.println(now);

        Date date = Date.from(now);
        System.out.println(date);
    }

    private static void test1(){
        String str = "{\"chat_type\":\"chat\",\"payload\":{\"ext\":{},\"bodies\":[{\"msg\":\"你好user222\",\"type\":\"txt\"}],\"from\":\"admin\",\"to\":\"user222\"},\"from\":\"admin\",\"to\":\"user222\",\"msg_id\":\"874788964261693432\",\"timestamp\":1621242477625,\"direction\":\"outgoing\"}";

        EmMsg emMsg = JSON.parseObject(str, EmMsg.class);
        System.out.println(emMsg);

    }

    @Data
    public static class EmMsg {

        private String msgId;

        private Date timestamp;

        private String from;

        private String to;

        private String chatType;

        private EmPayload payload;
    }

    @Data
    public static class EmPayload {

        private Object ext;

        private Collection bodies;

    }


}