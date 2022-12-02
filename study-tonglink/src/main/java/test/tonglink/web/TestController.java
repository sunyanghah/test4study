package test.tonglink.web;

import com.tongtech.client.common.ModeType;
import com.tongtech.client.consumer.PullCallback;
import com.tongtech.client.consumer.PullResult;
import com.tongtech.client.consumer.PullStatus;
import com.tongtech.client.consumer.common.PullType;
import com.tongtech.client.consumer.impl.TLQPullConsumer;
import com.tongtech.client.exception.TLQClientException;
import com.tongtech.client.message.Message;
import com.tongtech.client.message.MessageExt;
import com.tongtech.client.producer.TLQProducer;
import com.tongtech.client.remoting.exception.RemotingConnectException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author sunYang
 * @date 2022/10/18 17:42
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    private TLQPullConsumer consumer;
    TLQProducer producer = new TLQProducer();


    @GetMapping("/pull")
    public void testPull(@RequestParam("addr")String addr,@RequestParam("domain")String domain,
                         @RequestParam("subscribe")String subscribe) throws Exception{
        connect(addr, domain, subscribe);

        new Thread(() -> {
                // 只支持循环拉取
                while (true) {
                    try {
                        consumer.pullMessage(PullType.PullContinue, 0, 1, new PullCallback() {

                            @Override
                            public void onSuccess(PullResult pullResult) {

                                if (PullStatus.FOUND == pullResult.getPullStatus()) {
                                    List<MessageExt> msgFoundList = pullResult.getMsgFoundList();
                                    for (MessageExt messageExt : msgFoundList) {
                                        try {

                                            String body = new String(messageExt.getBody());
                                            log.info("-----------------message------" + body);
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
                    }catch (RemotingConnectException e){
                        try { consumer.shutdown(); }catch (Exception e2){}
                        reconnect(addr, domain, subscribe);
                    }catch (TLQClientException e){
                        try { consumer.shutdown(); }catch (Exception e2){}
                        reconnect(addr, domain, subscribe);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
        }).start();
    }

    private void reconnect(String addr,String domain,String subscribe){
        try {
            Thread.sleep(5000);
            consumer = new TLQPullConsumer();
            // 链接URL
            consumer.setNamesrvAddr(addr);
            // 监听的队列名称
            consumer.subscribe(subscribe);
            // 通信域
            consumer.setDomain(domain);
            // 指定点对点模式
            consumer.setModeType(ModeType.QUEUE);
            consumer.start();
        }catch (Exception e){
        }
    }

    private void connect(String addr,String domain,String subscribe){
        try {
            consumer = new TLQPullConsumer();
            // 链接URL
            consumer.setNamesrvAddr(addr);
            // 监听的队列名称
            consumer.subscribe(subscribe);
            // 通信域
            consumer.setDomain(domain);
            // 指定点对点模式
            consumer.setModeType(ModeType.QUEUE);
            consumer.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @PostMapping("/push")
    public void testPush(@RequestBody Map<String,String> map) throws Exception{
        String addr = map.get("addr");
        String domain = map.get("domain");
        producer.setNamesrvAddr(addr);
        producer.setDomain(domain);
        producer.setModeType(ModeType.QUEUE);
        producer.start();
        int i=0;
        while(true) {
            Thread.sleep(5000L);
            i++;
            Message message = new Message();
            try {
                String msgStr = map.get("message")+i;
                message.setTopicOrQueue(map.get("subscribe"));
                message.setBody(msgStr.getBytes());
                producer.send(message);
                log.info("----------发送消息成功---" + msgStr);
            } catch (RemotingConnectException e) {
                try {
                    producer.shutdown();
                } catch (Exception e2) {
                }
                reSend(message,addr,domain);
            } catch (TLQClientException e) {
                try {
                    producer.shutdown();
                } catch (Exception e2) {
                }
                reSend(message,addr,domain);
            } catch (Exception e) {
                log.error("发送消息失败");
                e.printStackTrace();
            }
        }

    }

    private void reSend(Message message,String nameAddr,String domain){
        try {
            producer = new TLQProducer();
            producer.setNamesrvAddr(nameAddr);
            producer.setDomain(domain);
            producer.setModeType(ModeType.QUEUE);
            producer.start();
            producer.send(message);
            log.info("----------重新发送消息成功---" + new java.lang.String(message.getBody()));
        }catch (Exception e){
        }

    }


    @GetMapping("/pull/topic1")
    public void testPullTopic1(@RequestParam("addr")String addr,@RequestParam("domain")String domain,
                         @RequestParam("subscribe")String subscribe) throws Exception{
        TLQPullConsumer consumer = new TLQPullConsumer();
        // 链接URL
        consumer.setNamesrvAddr(addr);
        // 监听的队列名称
        consumer.subscribe(subscribe);
        // 通信域
        consumer.setDomain(domain);
        // 指定点对点模式
        consumer.setModeType(ModeType.TOPIC);
        consumer.start();
        consumer.pullMessage(PullType.PullContinue, 0, 1, new PullCallback() {
            @Override
            public void onSuccess(PullResult pullResult) {
                // 务必需要判断状态。即使没有消息可拉取，这里也会进来。不过PullStatus不一样。
                if (PullStatus.FOUND == pullResult.getPullStatus()){
                    List<MessageExt> msgFoundList = pullResult.getMsgFoundList();
                    for (MessageExt messageExt : msgFoundList) {
                        try {
                            // 使用传入的消息处理类进行处理消息
                            log.info("-----topic1------");
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
    }

    @GetMapping("/pull/topic2")
    public void testPullTopic2(@RequestParam("addr")String addr,@RequestParam("domain")String domain,
                              @RequestParam("subscribe")String subscribe) throws Exception{
        TLQPullConsumer consumer = new TLQPullConsumer();
        // 链接URL
        consumer.setNamesrvAddr(addr);
        // 监听的队列名称
        consumer.subscribe(subscribe);
        // 通信域
        consumer.setDomain(domain);
        // 指定点对点模式
        consumer.setModeType(ModeType.TOPIC);
        consumer.start();
        consumer.pullMessage(PullType.PullOffset, 0, 1, new PullCallback() {
            @Override
            public void onSuccess(PullResult pullResult) {
                // 务必需要判断状态。即使没有消息可拉取，这里也会进来。不过PullStatus不一样。
                if (PullStatus.FOUND == pullResult.getPullStatus()){
                    List<MessageExt> msgFoundList = pullResult.getMsgFoundList();
                    for (MessageExt messageExt : msgFoundList) {
                        try {
                            // 使用传入的消息处理类进行处理消息
                            log.info("-----topic2------");
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
    }

    @PostMapping("/push/topic")
    public void testPushTopic(@RequestBody Map<String,String> map) throws Exception{

        TLQProducer producer = new TLQProducer();
        producer.setNamesrvAddr(map.get("addr"));
        producer.setDomain(map.get("domain"));
        producer.setModeType(ModeType.TOPIC);
        producer.start();

        try {
            Message message = new Message();
            message.setTopicOrQueue(map.get("subscribe"));
            String msgStr = map.get("message");
            message.setBody(msgStr.getBytes());
            producer.send(message);
            log.error("----------发送消息成功---"+msgStr);
        }catch (Exception e){
            log.error("----------发送消息失败");
            e.printStackTrace();
        }

    }

}
