package test.study.observation.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunYang
 * @Date 2021-02-04
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/do")
    public void doSomething(){

    }

}
