package test.stomp3.service.impl;

import test.stomp3.service.Test0815Service;

/**
 * @author sunYang
 * @date 2022/8/15 14:18
 */

public class Test0815ServiceImpl implements Test0815Service {
    @Override
    public void sayHello() {
        System.out.println("this is impl hello");
    }

    @Override
    public void doWork() {
        System.out.println("do do do do do");
    }
}
