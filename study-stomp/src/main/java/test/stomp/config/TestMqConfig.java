package test.stomp.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunYang
 * @Date 2020/10/9
 */
@Configuration
public class TestMqConfig {


    /////////////TOPIC交换机///////////////
    @Bean
    public Queue redQueue(){
        return QueueBuilder.nonDurable("red_queue").build();
    }
    @Bean
    public Queue greenQueue(){
        return QueueBuilder.nonDurable("green_queue").build();
    }
    @Bean
    public Queue yellowQueue(){
        return QueueBuilder.nonDurable("yellow_queue").build();
    }
    @Bean
    public Exchange exchange1(){
        return ExchangeBuilder.topicExchange("1009_exchange_1").durable(false).build();
    }
    @Bean
    public Binding bindingRed(){
        return new Binding("red_queue", Binding.DestinationType.QUEUE,"1009_exchange_1","*.red.fast",null);
    }
    @Bean
    public Binding bindingGreed(){
        return new Binding("green_queue", Binding.DestinationType.QUEUE,"1009_exchange_1","*.green.*",null);
    }
    @Bean
    public Binding bindingYellow(){
        return new Binding("yellow_queue", Binding.DestinationType.QUEUE,"1009_exchange_1","*.*.fast",null);
    }


    ////////////死信队列///////////

    /**
     * 声明正常业务队列 并 绑定死信交换机
     * @return
     */
    @Bean
    public Queue normalQueue1() {
        Map<String, Object> args = new HashMap<>(4);
        //      声明  死信交换机
        args.put("x-dead-letter-exchange", "1009_dead_letter_exchange_1");
        //      声明 死信路由键
        args.put("x-dead-letter-routing-key", "dead_letter_routing_key");
        //      超时时间 毫秒
        args.put("x-message-ttl",5000);
        return QueueBuilder.nonDurable("normal_queue").withArguments(args).build();
    }

    /**
     * 声明正常业务交换机
     * @return
     */
    @Bean
    public Exchange normalExchange(){
        return ExchangeBuilder.directExchange("normal_exchange").durable(false).build();
    }

    /**
     * 业务交换机绑定业务队列
     * @return
     */
    @Bean
    public Binding bindingNormal(){
        return new Binding("normal_queue", Binding.DestinationType.QUEUE,"normal_exchange","normal_routing_key",null);
    }

    /**
     * 声明死信队列A
     * @return
     */
    @Bean
    public Queue deadLetterQueue(){
        return QueueBuilder.nonDurable("1009_dead_letter_queue_1").build();
    }

    /**
     * 声明死信Exchange
     * @return
     */
    @Bean
    public Exchange deadLetterExchange(){
        return ExchangeBuilder.directExchange("1009_dead_letter_exchange_1").durable(false).build();
    }

    /**
     * 声明死信队列A绑定关系
     * @return
     */
    @Bean
    public Binding deadLetterBindingA(){
        return new Binding("1009_dead_letter_queue_1",Binding.DestinationType.QUEUE,"1009_dead_letter_exchange_1","dead_letter_routing_key",null);
    }

}
