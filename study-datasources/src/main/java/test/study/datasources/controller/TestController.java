package test.study.datasources.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.study.datasources.config.ApiResult;
import test.study.datasources.config.datasource.TargetDataSource;
import test.study.datasources.service.TestService;

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

    /**
     * 测试得到，注解不可加到service层及以下，只可在controller层使用。
     * @author sunYang
     * @param
     * @return test.study.datasources.config.ApiResult
     * @date 2022/1/7 18:04
     */
    @GetMapping
    @TargetDataSource(name = "test0105")
    public ApiResult testQuery(){

        List<? extends Object> result = testService.testQuery();
        return ApiResult.success(result);

    }

    @PutMapping
    @TargetDataSource(name = "test0105")
    public ApiResult testUpdate(){

        testService.testUpdate();

        return ApiResult.success();

    }

}
