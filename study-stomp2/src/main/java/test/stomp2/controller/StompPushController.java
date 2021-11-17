package test.stomp2.controller;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sunYang
 * @date 2021/11/1 10:35
 */
@RestController
@RequestMapping("/stomp")
public class StompPushController {

    @Resource
    private SimpMessagingTemplate messagingTemplate;

    private static final String EXCHANGE_NAME = "amq.topic";

    private static final String ROUTING_KEY_PREFIX = "vehicle_location";

    @GetMapping("/push2/{content}")
    public Map test2(@PathVariable("content")String content){

        messagingTemplate.convertAndSend("/topic/vehicle_location",content);

        Map map = new HashMap();
        map.put("result","success");
        return map;
    }

}
