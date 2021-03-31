package test.study.spring2.service.impl;

import org.springframework.stereotype.Service;
import test.study.spring2.service.TestProxyService;

/**
 * Created by dell on 2020/5/16.
 * @author dell
 */
@Service
public class TestProxyServiceImpl implements TestProxyService {
    @Override
    public void myPrint(){
        System.out.println("execute myPrint............");
    }
}
