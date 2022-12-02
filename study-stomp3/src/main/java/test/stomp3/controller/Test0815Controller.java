package test.stomp3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.stomp3.service.Test0815Service;

import javax.annotation.Resource;

/**
 * @author sunYang
 * @date 2022/8/15 14:16
 */
@RestController
@RequestMapping("/test0815")
public class Test0815Controller {

    @Resource
    private Test0815Service test0815Service;

    @GetMapping
    public void test0815() {
        test0815Service.sayHello();
        test0815Service.doWork();
    }

}
