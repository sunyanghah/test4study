package test.socket.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunYang
 * @Date 2020/11/3
 */
@RestController
@RequestMapping("/")
public class TestController {

    @GetMapping
    public void test1(){
        System.out.println("======/");
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
