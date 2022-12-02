package test.tonglink.web;

import com.tongtech.client.common.ModeType;
import com.tongtech.client.message.Message;
import com.tongtech.client.producer.TLQProducer;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author sunYang
 * @date 2022/11/17 17:01
 */
@Slf4j
public class TestSend {

    public static void main(String[] args) throws Exception{
        testSend();
    }

    public static void testSend() throws Exception{
        TLQProducer producer = new TLQProducer();
        producer.setNamesrvAddr("tcp://10.100.31.48:9888");
        producer.setDomain("domain1");
        producer.setModeType(ModeType.TOPIC);
        producer.start();

        try {
            Message message = new Message();
            message.setTopicOrQueue("topic1124");
            String msgStr = "this is message " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            message.setBody(msgStr.getBytes());
            producer.send(message);
            log.error("----------发送消息成功---"+msgStr);
        }catch (Exception e){
            log.error("----------发送消息失败");
            e.printStackTrace();
        }finally {
            producer.shutdown();
        }
    }

}
