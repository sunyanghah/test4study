package test.study.java.mianshi2020;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by dell on 2020/5/31.
 * @author dell
 */
@Slf4j
public class Test0531 {

    public static void main(String[] args) {
        test2();
    }

    public static void test1(){
        Thread t1 = new Thread("t1"){
            @Override
            public void run() {
                while(true){
                    if(Thread.currentThread().isInterrupted()){
                        break;
                    }

                    try {
                        sleep(1);
                    } catch (InterruptedException e) {
                       Thread.currentThread().interrupt();
                    }
                }
                log.info("t1结束");
            }
        };
        t1.start();
        log.info("main结束");
    }

    public static void test2(){
        Thread t2 = new Thread("t2"){
            @Override
            public void run() {
                while(true){
                    if(Thread.currentThread().isInterrupted()){
                        break;
                    }
                    try {
                        sleep(1);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                log.info("t2结束");
            }
        };
        t2.setDaemon(true);
        t2.start();
        log.info("main结束");
    }


}
