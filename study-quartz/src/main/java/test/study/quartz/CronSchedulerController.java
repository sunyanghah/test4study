package test.study.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author sunYang
 * @Date 2021-02-22
 */
@RestController
@RequestMapping("/test")
public class CronSchedulerController {

    @GetMapping("/test")
    public void cronScheduler() throws SchedulerException {
        /*
         * JobBuilder.newJob(HiJob.class)  --> 创建执行的job实现类
         * withIdentity("j1", "1") 创建该JobDetail 的名字和所在分组 第一个参数是名字, 第二个参数 分组
         * build()创建对象
         */
        JobDetail build = JobBuilder.newJob(HiJob.class).withIdentity("j1", "1").build();

        Date date = new Date();
        long startTime = date.getTime() + 3000;

        /*
         * TriggerBuilder.newTrigger() 创建一个Trigger
         * startAt(new Date(startTime)) 执行时间, 3秒后执行
         * withIdentity("t1", "1") Trigger所在的名字和分组,
         * 第一个参数是名字, 第二个参数 分组,因为和job是俩个对象, 名字 分组可以跟job重复
         * withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ?")) cron表达式初始化, 每秒执行一次
         * build()创建对象
         */
        CronTrigger c = TriggerBuilder.newTrigger()
                .withIdentity("t1", "1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 30 22 22 2 ? *"))
                .build();
        //创建SchedulerFactory对象  注意是new的是StdSchedulerFactory Std开头
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        //获得Scheduler
        Scheduler scheduler = schedulerFactory.getScheduler();
        //设置调度 的job 和trigger
        scheduler.scheduleJob(build, c);
        //开启调度
        scheduler.start();
    }

    @GetMapping("/shutdown")
    public void shutdown() throws SchedulerException {
//        TriggerBuilder.newTrigger().withIdentity()
        new StdSchedulerFactory().getScheduler().shutdown();
    }

}
