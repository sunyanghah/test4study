package test.study.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author sunYang
 * @Date 2020-12-17
 */
public class TestHelloWorld {

    public static void main(String[] args) throws SchedulerException, InterruptedException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        Trigger trigger = TriggerBuilder.newTrigger().startNow().build();

        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).build();

        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.start();

        //睡眠
        TimeUnit.SECONDS.sleep(5);
        scheduler.shutdown();
        System.out.println("--------scheduler shutdown ! ------------");

    }

    public static class HelloJob implements Job {

        @Override
        public void execute(JobExecutionContext context) throws JobExecutionException {
            System.out.println("hello world");
        }
    }

}
