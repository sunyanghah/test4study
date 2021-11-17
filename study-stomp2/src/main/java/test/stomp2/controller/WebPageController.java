package test.stomp2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author sunYang
 * @Date 2020/10/9
 */
@Controller
public class WebPageController {

    @GetMapping(value = {"/","/index"})
    public String index(){
        return "index";
    }

    @GetMapping(value = {"/index22"})
    public String index22(){
        return "index22";
    }


}
