package test.socket.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.socket.socket.MyClient;
import test.socket.socket.Test2;
import test.socket.socket.TestHandle;

import javax.annotation.Resource;
import javax.websocket.Session;
import java.util.List;

/**
 * @author sunYang
 * @Date 2020/11/3
 */
@RestController
@RequestMapping("/")
public class TestController {


    @Resource
    private TestHandle testHandle;

    @GetMapping("/test1")
    public void test1(){
        List<Session> sessionList = testHandle.getSessionList();
        System.out.println("-------------");
    }

    @GetMapping("/test")
    public void test2(){
        System.out.println("======/test");
    }

    @GetMapping("/abc")
    public void test3(){
        System.out.println("======/abc");
    }

    @GetMapping("/test/abc")
    public void test4(){
        System.out.println("======/test/abc");
    }

}
