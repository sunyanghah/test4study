package test.security.jwt.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/hello")
    public Map<String,String> hello(){
        Map<String,String> map = new HashMap<>();
        map.put("name","sunYang");
        map.put("age","18");
        return map;
    }

    @GetMapping("/hello2")
    @PreAuthorize("hasAnyAuthority('sys:dept:list')")
    public Map<String,String> hello2(){
        Map<String,String> map = new HashMap<>();
        map.put("name","sunYang");
        map.put("age","18");
        return map;
    }

    @GetMapping("/hello3")
    @PreAuthorize("hasAnyAuthority('code1','bbb')")
    public Map<String,String> hello3(){
        Map<String,String> map = new HashMap<>();
        map.put("name","sunYang");
        map.put("age","18");
        return map;
    }

}
