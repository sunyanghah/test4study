package test.study.imserver.web;

import com.easemob.im.server.EMService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author sunYang
 * @Date 2021-04-15
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private EMService emService;

    @GetMapping("/create")
    public String create(){
        emService.user().create("user1", "user1").doOnError(e -> {
            e.printStackTrace();
        });
        return "success";
    }

}
