package test.study.java.mianshi2020;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by dell on 2020/5/10.
 * @author dell
 */
public class Test0510_3 {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 3, 0, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(5),new ThreadPoolExecutor.DiscardPolicy());

        CountDownLatch latch = new CountDownLatch(3);

        Worker w1 = new Worker(latch,"张三");
        Worker w2 = new Worker(latch,"李四");
        Worker w3 = new Worker(latch,"王二");

        Boss boss = new Boss(latch);

        executor.execute(w3);
        executor.execute(w2);
        executor.execute(w1);
        executor.execute(boss);

        executor.shutdown();
    }

    static class Worker implements Runnable{

        private CountDownLatch downLatch;
        private String name;

        public Worker(CountDownLatch downLatch, String name){
            this.downLatch = downLatch;
            this.name = name;
        }

        @Override
        public void run() {
            this.doWork();
            try{
                TimeUnit.SECONDS.sleep(new Random().nextInt(10));
            }catch(InterruptedException ie){
            }
            System.out.println(this.name + "活干完了！");
            this.downLatch.countDown();

        }

        private void doWork(){
            System.out.println(this.name + "正在干活!");
        }

    }

    static class Boss implements Runnable {

        private CountDownLatch downLatch;

        public Boss(CountDownLatch downLatch){
            this.downLatch = downLatch;
        }

        @Override
        public void run() {
            System.out.println("老板正在等所有的工人干完活......");
            try {
                this.downLatch.await();
            } catch (InterruptedException e) {
            }
            System.out.println("工人活都干完了，老板开始检查了！");
        }

    }

}
