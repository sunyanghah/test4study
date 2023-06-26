package test.study.spring2.eventhandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import test.study.spring2.event.TestEvent;

/**
 * @author sunYang
 * @Date 2021-03-15
 */
@Component
@Slf4j
public class TestEventHandler implements ApplicationListener<TestEvent> {

    @Override
    public void onApplicationEvent(TestEvent testEvent) {
       log.info("111111111111111");
        try {
            System.out.println(testEvent.getSomething());
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("222222222222222");
    }

}
