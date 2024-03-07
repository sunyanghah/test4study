package test.study.java.mianshi2020;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 场景：实现一个消息队列，有多个线程会往该队列里面写消息，同时也会存在多个线程会从消息里面读消息，队列的容量只有10个。
 *
 * 条件：
 *
 * 队列不为满条件：队列里面消息没有满的情况下才能往队里面添加消息。
 *
 * 队列不为空条件：消费消息的时候队列里必须有消息才进行消费。
 *
 * 加锁：因为是多线程所以需要防止消息被多个线程同时消费，同时也要防止写消息的时候一个线程存的消息被其他线程覆盖，所以队列操作的时候必须加锁。
 * @author sunyang
 * @date 2023-10-28
 * @desc
 */
public class Test0513_lock_4_queue {

    private static MyQueue myQueue = new MyQueue();

    public static void main(String[] args) {
        for(int i=1; i<=10; i++){
            Thread provider = new Thread(() -> {
                while (true){
                    myQueue.write("消息");
                }
            },"生产线程"+i);
            Thread consumer = new Thread(() -> {
                while (true){
                    myQueue.read();
                }
            },"消费线程"+i);
            provider.start();
            consumer.start();
        }
    }
    public static class MyQueue {

        private Lock lock = new ReentrantLock();//锁
        private List listQueue = new ArrayList();//存储消息的集合
        private Condition notNull = lock.newCondition();//队列不为空
        private Condition notFull = lock.newCondition();//队列不为满

        public void write(String message){
            lock.lock();//操作队列先加锁
            try {
                //队列满了，通知消费者线程，生产线程阻塞
                while (listQueue.size() >= 10){
                    notNull.signal();
                    System.out.println("队列已满"+ Thread.currentThread().getName()+"等待"+listQueue.size());
                    notFull.await();
                }

                //往队列添加一条消息，同时通知消费者有新消息了
                listQueue.add(message);
                System.out.println(Thread.currentThread().getName()+"生产一条消息"+listQueue.size());
                notNull.signal();//通知消费者线程
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();//释放锁
            }
        }

        public void read(){
            lock.lock();//操作队列先加锁
            try {
                //队列空了，通知生产线程，消费线程阻塞
                while (listQueue.size() == 0){
                    System.out.println("队列已空"+ Thread.currentThread().getName()+"等待"+listQueue.size());
                    notNull.await();
                }
                //队列删除一条消息，同时通知生产者队列有位置了
                listQueue.get(0);
                listQueue.remove(0);
                System.out.println(Thread.currentThread().getName()+"消费一条消息"+listQueue.size());
                notFull.signal();//同时通知生产者队列

            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}
