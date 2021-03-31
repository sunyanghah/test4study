package test.study.java.mianshi2020;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by dell on 2020/6/14.
 * @author dell
 */
@Slf4j
public class Test0614 {
    public static void main(String[] args) {
        GuardedObject guardedObject = new GuardedObject();
        new Thread(()->{
            log.info("等待结果");
            Object object = guardedObject.get();
            log.info("获取结果："+object.toString());
        },"t1").start();
        new Thread(()->{
            log.info("开始工作");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            guardedObject.complete("我完成了");
        },"t2").start();
    }
}
class GuardedObject{
    private volatile Object response;
    public Object get(){
        synchronized (this){
            while (response == null){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return response;
        }
    }
    public void complete(Object response){
        synchronized (this){
            this.response = response;
            this.notifyAll();
        }
    }
}
