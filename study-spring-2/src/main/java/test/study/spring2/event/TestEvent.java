package test.study.spring2.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author sunYang
 * @Date 2021-03-15
 */
public class TestEvent extends ApplicationEvent {
    public TestEvent(Object source) {
        super(source);
    }
}
