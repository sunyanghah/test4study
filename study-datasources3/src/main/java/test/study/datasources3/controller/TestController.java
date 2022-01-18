package test.study.datasources3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.study.datasources3.config.ApiResult;
import test.study.datasources3.service.TestService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sunYang
 * @date 2022/1/7 13:55
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private TestService testService;

    @GetMapping
    public ApiResult testQuery(){

        List<? extends Object> result = testService.testQuery();
        return ApiResult.success(result);

    }

    @PutMapping
    public ApiResult testUpdate(){

        testService.testUpdate();

        return ApiResult.success();

    }

    @PutMapping("/testUpdate2")
    public ApiResult testUpdate2(){

        testService.testUpdate2();

        return ApiResult.success();
    }

}
