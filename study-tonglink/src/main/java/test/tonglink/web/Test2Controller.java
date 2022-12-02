package test.tonglink.web;

import com.alibaba.fastjson.JSON;
import com.binary.core.http.HttpClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author sunYang
 * @date 2022/11/8 11:39
 */
@RestController
@RequestMapping("/test2")
public class Test2Controller {

    @GetMapping
    public void test2() throws Exception{
//        HttpClient httpClient = HttpClient.getInstance("https://10.100.31.48:52011");
//        httpClient.setRequestMethod("POST");
//        String rest = httpClient.rest("/message/countByQueue", "{\"queues\":[{\"queueName\": \"eventQueue\",\"domainName\": \"domain1\"}]}");
//        System.out.println(rest);

        HttpUtil httpUtil = HttpUtil.getInstance();
        HttpResult httpResult = httpUtil.doPost("https://10.100.31.48:52011/cluster/monitor", "{}");
        String responseString = httpResult.getResponseString();
        Map rtMap = JSON.parseObject(responseString, Map.class);
        Object data = rtMap.get("data");
        Map dataMap = JSON.parseObject(data.toString(), Map.class);
        System.out.println("----"+dataMap.get("state"));

        System.out.println("-----------------------------------");

        HttpUtil httpUtil2 = HttpUtil.getInstance();
        HttpResult httpResult2 = httpUtil2.doPost("https://10.100.31.48:52011/cluster/lookup", "{}");
        String responseString2 = httpResult2.getResponseString();
        Map rtMap2 = JSON.parseObject(responseString2, Map.class);
        Object data2 = rtMap2.get("data");
        List<Map> brokerList = JSON.parseArray(data2.toString(), Map.class);
        for (Map map : brokerList) {
            System.out.println(map.get("brokerName")+"===="+map.get("condition"));
        }
    }


}
