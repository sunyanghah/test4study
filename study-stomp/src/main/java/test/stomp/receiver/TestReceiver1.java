package test.stomp.receiver;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author sunYang
 * @Date 2020/10/9
 */
@Component
@Slf4j
public class TestReceiver1 {

    @RabbitListener(queues = "red_queue")
    public void red(Message message, Channel channel) throws Exception{
        log.info("------this is receiver red------{}-----------",new String(message.getBody()));
//        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }

    @RabbitListener(queues = "green_queue")
    public void green(Message message, Channel channel) throws Exception{
        log.info("------this is receiver green------{}-----------",new String(message.getBody()));
//        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }

    @RabbitListener(queues = "yellow_queue")
    public void yellow(Message message, Channel channel) throws Exception{
        log.info("------this is receiver yellow------{}-----------",new String(message.getBody()));
//        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }

    /**
     * 在消费者定义里直接声明交换机，队列，以及绑定关系
     * @param message
     * @param channel
     * @throws Exception
     */
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue(value = "white_queue",durable = "false"),
                    exchange = @Exchange(value = "1009_exchange_2",type = "direct"),
                    key = "white_key"
            )
    })
    public void white(Message message, Channel channel) throws Exception{
        log.info("------this is receiver white------{}-----------",new String(message.getBody()));
//        throw new Exception();
//        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }
//
//    @RabbitListener(queues = "normal_queue")
//    public void normal(Message message, Channel channel) throws Exception{
//        log.info("------this is receiver normal------{}-----------",new String(message.getBody()));
//        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
//    }

    @RabbitListener(queues = "1009_dead_letter_queue_1")
    public void deadLetter(Message message, Channel channel) throws Exception{
        log.info("------this is receiver dead letter------{}-----------",new String(message.getBody()));
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }


}
