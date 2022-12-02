package test.socket2.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.socket2.config.WebSocketService;

import javax.annotation.Resource;

/**
 * @author sunYang
 * @date 2022/9/8 15:08
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private WebSocketService webSocketService;

    @GetMapping
    public void test() throws InterruptedException {
        int i =0;
        while (true) {

            webSocketService.broadcast(""+i++);

            Thread.sleep(2000);
        }
    }

}
