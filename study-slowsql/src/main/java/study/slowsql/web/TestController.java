package study.slowsql.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.slowsql.service.TestService;

import javax.annotation.Resource;

/**
 * @author sunYang
 * @date 2023/1/5 17:17
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private TestService testService;

    @GetMapping
    public void test(){
        testService.test();
    }

}
