package test.study.spring2.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import test.study.spring2.config.TestProperty;
import test.study.spring2.event.TestEvent;
import test.study.spring2.proxy.DAO;

import javax.annotation.Resource;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dell on 2020/5/18.
 * @author dell
 */
@Controller
@Slf4j
public class TestController2 {

    @Resource
    private DAO dao;
    @Resource
    private ApplicationEventPublisher applicationEventPublisher;
    @Resource
    private TestProperty testProperty;

    @GetMapping("/myTest2")
    public void myTest2(){
        System.out.println("myTest2 is here");
    }

    @GetMapping("/myTest4")
    public void myTest4() {
        log.info("aaaaaaaaaa");
        applicationEventPublisher.publishEvent(new TestEvent(this));
        applicationEventPublisher.publishEvent(new TestEvent(this, "this is data to transfer"));
        log.info("bbbbbbbbbb");
    }

    @GetMapping("/myTest3")
    @ResponseBody
    public void myTest3(){
        Map map = new HashMap();
        map.put("a","A");
        map.put("b","B");
        log.info("----"+Proxy.isProxyClass(dao.getClass()));
        dao.tttt("zhangsan",12,map);
    }

    @GetMapping("/sdfsfa")
    public void sasdf(){
        System.out.println("sdfsafs");
    }

    @GetMapping("/testResp1")
    public void testResp1Method(){
        System.out.println("testResp1");
    }

    @GetMapping("/testResp2")
    public String testResp2Method(){
        System.out.println("testResp2");
        return "/testResp2View.jsp";
    }

    @GetMapping("/testResp3")
    @ResponseBody
    public Map testResp3Method(){
        System.out.println("testResp3");
        Map map = new HashMap<>();
        map.put("name","张三");
        return map;
    }


}
