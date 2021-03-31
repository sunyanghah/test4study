package test.stomp.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import test.stomp.dto.ProducerTestDto;

import javax.annotation.Resource;

/**
 * @author sunYang
 * @Date 2020/10/9
 */
@RestController
public class ProducerController {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/test1")
    public void test1(ProducerTestDto dto){
        rabbitTemplate.convertAndSend("1009_exchange_1",dto.getRoutingKey(),"i will not tell you the message ");
    }

    @GetMapping("/test2")
    public void test2(ProducerTestDto dto){
        rabbitTemplate.convertAndSend("1009_exchange_2",dto.getRoutingKey(),"maybe i can tell you the message ");
    }

    /**
     * 利用消息超时和死信队列完成延时消费
     * @param dto
     */
    @GetMapping("/test3")
    public void test3(ProducerTestDto dto){
        rabbitTemplate.convertAndSend("normal_exchange",dto.getRoutingKey(),"the message is normal ");
    }


}
