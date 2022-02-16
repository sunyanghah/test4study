package test.stomp2.controller;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author sunYang
 * @date 2021/11/1 10:35
 */
@Component
public class StompPushSchedule {

    @Resource
    private SimpMessagingTemplate messagingTemplate;

    private static final String EXCHANGE_NAME = "amq.topic";

    private static final String ROUTING_KEY_PREFIX = "vehicle_location";

    @Scheduled(initialDelay = 3000,fixedDelay = 3000)
    public void test2() throws UnknownHostException {
        InetAddress addr = InetAddress.getLocalHost();

        messagingTemplate.convertAndSend("/topic/vehicle_location", System.currentTimeMillis());

    }




}
