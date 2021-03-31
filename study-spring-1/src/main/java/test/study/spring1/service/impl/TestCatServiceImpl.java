package test.study.spring1.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import test.study.spring1.service.TestAbstractService;

import java.util.function.Function;

/**
 * @author sunYang
 * @Date 2021-03-26
 */
@Service("cat")
@Component("cat")
public class TestCatServiceImpl implements TestAbstractService {


    @Override
    public String getInfo() {
        return "cat";
    }



    private void test (Function function){

    }

}
