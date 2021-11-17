package test.study.shiro2.web;

import com.alibaba.fastjson.JSON;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.study.shiro2.config.ApiResult;
import test.study.shiro2.entity.SysUser;

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

    @GetMapping("/t3")
    public ApiResult test3(){
        Object principal = SecurityUtils.getSubject().getPrincipal();
        SysUser sysUser = JSON.parseObject(principal.toString(), SysUser.class);
        System.out.println(sysUser.getId()+"==============="+sysUser.getUsername());
        return ApiResult.success(sysUser);
    }

}
