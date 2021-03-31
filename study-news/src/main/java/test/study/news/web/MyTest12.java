package test.study.news.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import test.study.common.platform.IdGenerator;
import test.study.news.service.TestService;

import java.util.List;

/**
 * Created by dell on 2019/8/27.
 */
@RestController
public class MyTest12 {

    @Autowired
    private TestService testService;


    @GetMapping("/test12/test")
    public void test() throws Exception{

        testService.test();

    }


}
