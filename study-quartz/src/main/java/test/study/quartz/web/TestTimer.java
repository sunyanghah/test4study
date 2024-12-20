package test.study.quartz.web;

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
                System.out.println("-------设定要指定任务----延迟5秒执行一次，之后每1秒执行一次----");
            }
        }, 5000,1000);// 设定指定的时间time,此处为2000毫秒

        timer.schedule(new TimerTask() {
            public void run() {
                System.out.println("-------设定要指定任务-----延迟2秒，只执行一次---");
            }
        }, 2000);// 设定指定的时间time,此处为2000毫秒
    }

}
