package test.study.spring1.service.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import test.study.spring1.service.TestServiceExtendService;

/**
 * @author sunYang
 * @Date 2021-03-26
 */
@Service("dog")
@Component("dog")
public class TestDogServiceImpl implements TestServiceExtendService {


    @Override
    public String getInfo() {
        return "dog";
    }

    @Override
    public void otherMethod() {
        System.out.println("other");
    }
}
