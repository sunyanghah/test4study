package test.socket.web;

import org.springframework.web.bind.annotation.*;
import test.socket.config.ApiVersion;

/**
 * @author sunyang
 * @date 2023-11-17
 * @desc
 */
@RestController
@RequestMapping("/{version}/test1117")
public class Test20231117Controller {

    @RequestMapping(value = "/test",params = {"version=v1"})
    @ApiVersion(1)
    public void testV1(){
        System.out.println("this is testV1");
    }

    @RequestMapping(value = "/test",params = {"version=v2"})
    @ApiVersion(2)
    public void testV2(){
        System.out.println("this is testV2");
    }

}
