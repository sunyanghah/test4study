package test.study.java.mianshi2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

/**
 * Created by dell on 2020/5/31.
 */
public class Test0531_2 {


    public static void main(String[] args) throws Exception{
        TicketWindow ticketWindow = new Test0531_2().new TicketWindow(500);
        List<Thread> threadList = new ArrayList<>();
        Random random = new Random();
        List<Long> sellTicketNum = new Vector<>(); //不要使用arrayList
        for (int i = 1;i<=500;i++){
            Thread thread = new Thread(){
                @Override
                public void run() {
                    int ticketNum = random.nextInt(2) + 1;
                    long sell = ticketWindow.sell(ticketNum);
                    if (sell == 0){
                        System.out.println("我没抢到票呢");
                    }else if ( sell < ticketNum){
                        System.out.println("票不够啦，我只买到了"+sell+"张票");
                    }else {
                        System.out.println("我买到了" + sell + "张票");
                    }
                    sellTicketNum.add(sell);
                }
            };
            threadList.add(thread);
            thread.start();
        }

        for (Thread thread : threadList) {
            thread.join();
        }

        long sellTicketTotal = 0;
        for (Long aLong : sellTicketNum) {
            sellTicketTotal+=aLong;
        }
        System.out.println("总卖出："+sellTicketTotal);
//        System.out.println("总卖出票："+sellTicketNum.stream().mapToLong(sellNum -> sellNum).sum());
        System.out.println("剩余票："+ticketWindow.getCountNow());
    }

    class TicketWindow{

        public TicketWindow(long ticketCount){
            this.ticketCount = ticketCount;
        }

        private volatile long ticketCount;

//        private long ticketCount;

        public long getCountNow(){
            return ticketCount;
        }

        public synchronized long sell(int sellNum){
            long realSell = sellNum;
            if (ticketCount-sellNum > 0){
                ticketCount-=sellNum;
            }else {
                realSell = ticketCount;
                ticketCount = 0;
            }
            return realSell;
        }

    }

}
