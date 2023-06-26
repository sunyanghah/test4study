package test.study.spring2.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @author sunYang
 * @Date 2021-03-15
 */
public class TestEvent extends ApplicationEvent {

    @Getter
    private String something;

    public TestEvent(Object source) {
        super(source);
    }

    public TestEvent(Object source, String something){
        super(source);
        this.something = something;
    }

}
