package test.webflux.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author sunYang
 * @Description:
 * @Title: Test1Controller
 * @Package test.webflux.web
 * @date 2021-06-0216:13
 */
@RestController
@RequestMapping("/test1")
public class Test1Controller {

    @GetMapping("/t1")
    public Mono<String> t1(){
        return Mono.just("123123");
    }

}