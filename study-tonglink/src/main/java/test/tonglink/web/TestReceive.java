package test.tonglink.web;

import com.tongtech.client.common.ModeType;
import com.tongtech.client.consumer.PullCallback;
import com.tongtech.client.consumer.PullResult;
import com.tongtech.client.consumer.PullStatus;
import com.tongtech.client.consumer.common.PullType;
import com.tongtech.client.consumer.impl.TLQPullConsumer;
import com.tongtech.client.message.MessageExt;
import lombok.extern.slf4j.Slf4j;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.List;

/**
 * @author sunYang
 * @date 2022/11/17 17:01
 */
@Slf4j
public class TestReceive {

    public static void main(String[] args) throws Exception {

//        for (int i = 0; i < 5; i++) {
//            System.out.println(getUniqueGroup());
//        }


        testReceive();
//        testReceive2();
//        testReceive3();
    }

    private static String getUniqueGroup(){
        //获取机器编码
        long workerId= getMachineNum();
        //获取进程编码
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        long processId=Long.valueOf(runtimeMXBean.getName().split("@")[0]).longValue();

        return ""+workerId;
    }

    private static long getMachineNum(){
        long machinePiece;
        StringBuilder sb = new StringBuilder();
        Enumeration<NetworkInterface> e = null;
        try {
            e = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e1) {
            e1.printStackTrace();
        }
        while (e.hasMoreElements()) {
            NetworkInterface ni = e.nextElement();
            sb.append(ni.toString());
        }
        machinePiece = sb.toString().hashCode();
        return machinePiece;
    }

    public static void testReceive() throws Exception{
        TLQPullConsumer consumer = new TLQPullConsumer();
        // 链接URL
        consumer.setNamesrvAddr("tcp://10.100.31.48:9888");
        // 监听的队列名称
        consumer.subscribe("topic1124");
        // 通信域
        consumer.setDomain("domain1");
        // 指定点对点模式
        consumer.setModeType(ModeType.TOPIC);
        consumer.start();
        consumer.setAutoCommit(true);
        consumer.pullMessage(PullType.PullEndContinue, 0, 1, new PullCallback() {
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


    public static void testReceive2() throws Exception{
        TLQPullConsumer consumer = new TLQPullConsumer("testr2");
        // 链接URL
        consumer.setNamesrvAddr("tcp://10.100.31.48:9888");
        // 监听的队列名称
        consumer.subscribe("dipTest");
        // 通信域
        consumer.setDomain("domain1");
        // 指定点对点模式
        consumer.setModeType(ModeType.TOPIC);
        consumer.start();

        consumer.pullMessage(PullType.PullEndContinue, 0, 1, new PullCallback() {
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

    public static void testReceive3() throws Exception{
        TLQPullConsumer consumer = new TLQPullConsumer("testr3");
        // 链接URL
        consumer.setNamesrvAddr("tcp://10.100.31.48:9888");
        // 监听的队列名称
        consumer.subscribe("dipTest");
        // 通信域
        consumer.setDomain("domain1");
        // 指定点对点模式
        consumer.setModeType(ModeType.TOPIC);
        consumer.start();

        consumer.pullMessage(PullType.PullEndContinue, 0, 1, new PullCallback() {
            @Override
            public void onSuccess(PullResult pullResult) {

                // 务必需要判断状态。即使没有消息可拉取，这里也会进来。不过PullStatus不一样。
                if (PullStatus.FOUND == pullResult.getPullStatus()){
                    List<MessageExt> msgFoundList = pullResult.getMsgFoundList();
                    for (MessageExt messageExt : msgFoundList) {
                        try {
                            // 使用传入的消息处理类进行处理消息
                            log.info("-----topic3------");
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

}
