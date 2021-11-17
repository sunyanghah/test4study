package test.study.shiro1.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TestScheduler {


    /**
     * 每晚零点30分
     * @author sunYang
     * @param
     * @return void
     * @date 2021/7/29 14:17
     */
    @Scheduled(cron = "0/5 * * * * ?")
//    @Scheduled(cron = "0 0 23 * * ?")
    public void modelGenerate() throws Exception {
        log.info("************************");
        Thread.sleep(8000);


    }


}
