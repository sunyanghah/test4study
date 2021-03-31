package test.study.spring1.service.impl;

import org.springframework.stereotype.Service;
import test.study.spring1.service.TestProxy;

/**
 * Created by dell on 2020/5/16.
 * @author dell
 */
@Service
public class TestProxyImpl implements TestProxy {


    @Override
    public void myPrint(){
        System.out.println("execute myPrint............");
    }
}
