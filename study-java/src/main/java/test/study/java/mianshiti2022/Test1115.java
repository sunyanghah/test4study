package test.study.java.mianshiti2022;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author sunYang
 * @date 2022/11/15 17:11
 */
public class Test1115 {

    public static void main(String[] args) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);

        scheduledThreadPoolExecutor.scheduleWithFixedDelay(() -> {
            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()));
        }, 1,100, TimeUnit.MILLISECONDS);

        System.out.println("it's begin");

    }

}
