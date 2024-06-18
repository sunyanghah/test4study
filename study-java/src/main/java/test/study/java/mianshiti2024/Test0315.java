package test.study.java.mianshiti2024;

import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

/**
 * @author sun yang
 * @date 2024/3/15
 */
public class Test0315 {

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString());
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                // 需要执行的代码
                System.out.println("每3秒执行一段代码");
            }
        }, 0, 3000);
        System.out.println("sdfsdfs");
    }

}
