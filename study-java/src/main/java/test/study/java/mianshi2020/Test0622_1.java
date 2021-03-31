package test.study.java.mianshi2020;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by dell on 2020/6/22.
 * @author dell
 */
public class Test0622_1 {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,5,0, TimeUnit.SECONDS,new LinkedBlockingQueue<>(2),new ThreadPoolExecutor.AbortPolicy());
        for(int i=0;i<7;i++) {
            executor.execute(() -> {
                try {
                    System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(Calendar.getInstance().getTime()));
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executor.shutdown();
    }

}
