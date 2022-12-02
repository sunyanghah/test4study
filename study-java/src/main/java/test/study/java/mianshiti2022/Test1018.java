package test.study.java.mianshiti2022;

import com.tongtech.client.common.ModeType;
import com.tongtech.client.consumer.PullCallback;
import com.tongtech.client.consumer.PullResult;
import com.tongtech.client.consumer.PullStatus;
import com.tongtech.client.consumer.common.PullType;
import com.tongtech.client.consumer.impl.TLQPullConsumer;
import com.tongtech.client.message.Message;
import com.tongtech.client.message.MessageExt;
import com.tongtech.client.producer.TLQProducer;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author sunYang
 * @date 2022/10/18 11:16
 */
@Slf4j
public class Test1018 {

    public static void main(String[] args) throws Exception{
        testSend();
    }

    public static void testPull() throws Exception{
        TLQPullConsumer consumer = new TLQPullConsumer();
        // 链接URL
        consumer.setNamesrvAddr("tcp://10.100.31.48:9888");
        // 监听的队列名称
        consumer.subscribe("queue1");
        // 通信域
        consumer.setDomain("domain1");
        // 指定点对点模式
        consumer.setModeType(ModeType.QUEUE);
        consumer.start();

        // 一次拉一条，消息量大时，可批量拉取优化
        consumer.pullMessage(PullType.PullContinue, 0, 1, new PullCallback() {

            @Override
            public void onSuccess(PullResult pullResult) {
                // 务必需要判断状态。即使没有消息可拉取，这里也会进来。不过PullStatus不一样。
                if (PullStatus.FOUND == pullResult.getPullStatus()){
                    List<MessageExt> msgFoundList = pullResult.getMsgFoundList();
                    for (MessageExt messageExt : msgFoundList) {
                        try {
                            // 使用传入的消息处理类进行处理消息
                            log.info("-----------");
                            log.info(new String(messageExt.getBody()));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            @Override
            public void onException(Throwable e) {                              /* 拉取消息异常 */
                log.error("Create queue receiver failed: " + e.getMessage());
            }

        }, 500000);
        Thread.sleep(1000);

    }

    public static void testSend() throws Exception{
        TLQProducer producer = new TLQProducer();
        producer.setNamesrvAddr("tcp://122.9.45.37:9888");
        producer.setDomain("domain1");
        producer.setModeType(ModeType.QUEUE);
        producer.start();


        String str ="[{\"Status\":\"1\",\"kpiInstance\":\"OS-214.10.0.161\",\"SourceSeverity\":\"3\",\"SourceID\":\"1\",\"SourceIdentifier\":\"集中监控web服务器\",\"Severity\":\"3\",\"SourceEventID\":\"集中监控web服务器\",\"SourceAlertKey\":\"CPU使用率\",\"SourceCIName\":\"214.10.0.161\",\"Summary\":\"过高32131231\",\"ciApplication\":\"测试\",\"CIObject\":{\"name\":\"李四\"},\"LastOccurrence\":\"2022-10-21 14:03:25\"}]";

        try {
            Message message = new Message();
            message.setTopicOrQueue("eventQueue");
            message.setBody(str.getBytes());
            producer.send(message);
            log.error("发送消息成功");
        }catch (Exception e){
            log.error("发送消息失败");
            e.printStackTrace();
        }finally {
            producer.shutdown();
        }
    }

}
