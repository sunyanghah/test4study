package test.rabbitmq.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.stereotype.Component;

/**
 * Created by dell on 2018/12/27.
 * @author dell
 */
@Component
//@RabbitListener(queues = "topic.messages")
public class TopicMessage2Receiver {

//    @RabbitHandler
    public void process(String msg) {
        System.out.println("topicMessageReceiver--------2  : " +msg);
    }

}
