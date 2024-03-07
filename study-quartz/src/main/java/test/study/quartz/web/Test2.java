package test.study.quartz.web;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author sun yang
 * @date 2024/2/26
 */
public class Test2 {

    public static void main(String[] args) throws Exception{

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        JobKey jobKey = new JobKey("jobName", "group");
        scheduler.deleteJob(jobKey);

        JobDetail job = JobBuilder.newJob(HelloJob.class).withIdentity("jobName", "group").build();

        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.MINUTE, -1);
        Date startTime = instance.getTime();

//        CalendarIntervalScheduleBuilder calendarIntervalSchedule = CalendarIntervalScheduleBuilder
//                .calendarIntervalSchedule().withMisfireHandlingInstructionDoNothing();

        CalendarIntervalScheduleBuilder calendarIntervalSchedule = CalendarIntervalScheduleBuilder
                .calendarIntervalSchedule();

        calendarIntervalSchedule.withIntervalInSeconds(180);

        CalendarIntervalTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("triggerName", "group")
                .startAt(startTime)
                .withSchedule(calendarIntervalSchedule)
                .build();

        //设置调度 的job 和trigger
        scheduler.scheduleJob(job, trigger);

        System.out.println("===================="+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        //开启调度
        scheduler.start();
    }

    public static class HelloJob implements Job {

        @Override
        public void execute(JobExecutionContext context) throws JobExecutionException {
            String dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            System.out.println("----------hello:"+ dateFormat);
        }

    }

}
