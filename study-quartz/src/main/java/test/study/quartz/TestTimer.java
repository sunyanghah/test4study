package test.study.quartz;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author sunYang
 * @Date 2020/10/29
 */
public class TestTimer {

    public static void main(String[] args) {
        test1();
    }

    public static void test1(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("-------设定要指定任务--------");
            }
        }, 2000);// 设定指定的时间time,此处为2000毫秒
    }

}
