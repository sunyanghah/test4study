package test.study.shiro1.web;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/t1")
    @RequiresPermissions(value = {"a","b"},logical = Logical.AND)
    public void test1(){
        System.out.println("111111111111111111");
    }

    @GetMapping("/t2")
    public void test2(){
        System.out.println("2222222222222222222222222");
    }

}
