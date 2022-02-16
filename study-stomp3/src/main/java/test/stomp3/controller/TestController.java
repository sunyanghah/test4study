package test.stomp3.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import test.stomp3.dto.Shout;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunYang
 * @date 2022/2/14 17:24
 */
@RestController
public class TestController {

    @Resource
    private SimpMessagingTemplate simpMessagingTemplate;
    private Map<String,Long> clientMap = new HashMap<>();

    @MessageMapping("/app/marco")
    public Shout handleShout(Shout incoming) {

        System.out.println("Received message: " + incoming.getMessage());

        Shout outgoing = new Shout();
        outgoing.setMessage("Polo!");

        return outgoing;
    }

    @GetMapping("/queryClient")
    public Map<String,Long> queryClient(){
        return clientMap;
    }

    @MessageMapping("/app/heartbeat")
    public Shout handleHeartbeat(Shout incoming){
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println("收到心跳----------------------"+currentTimeMillis);
        clientMap.put(incoming.getMessage(), currentTimeMillis);
        Shout outgoing = new Shout();
        outgoing.setMessage("received");
        return outgoing;
    }

    @Scheduled(initialDelay = 30000,fixedDelay = 10000)
    public void checkClient(){
        List<String> expiredClient = new ArrayList<>();
        for (Map.Entry<String, Long> entry : clientMap.entrySet()) {
            if (System.currentTimeMillis()-entry.getValue() > 30000){
                System.out.println(entry.getKey()+"---过期了------"+entry.getValue());
                expiredClient.add(entry.getKey());
            }
        }
        expiredClient.forEach(clientMap::remove);
    }

    @GetMapping("/sendToUser")
    public void sendToUser(@RequestParam("message")String message,@RequestParam("user")String user){
        Shout outgoing = new Shout();
        outgoing.setMessage(message);
        // 发送给指定用户
        simpMessagingTemplate.convertAndSendToUser(user,"/topic/testSendToUser", JSON.toJSONString(outgoing));
    }

}
