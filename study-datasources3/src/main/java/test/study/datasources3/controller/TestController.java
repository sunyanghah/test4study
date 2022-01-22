package test.study.datasources3.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.springframework.web.bind.annotation.*;
import test.study.datasources3.config.ApiResult;
import test.study.datasources3.service.TestService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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

    @PostMapping("/transmission/realtime/ntms/netStatusByTime")
    public List<Map<String, Object>> test3(@RequestBody Map<String,Object> map){
        String str =  "[{\"timeStamp\":61200,\"trainInfoList\":[{\"lineCode\":150,\"sectionCode\":\"15005-15006\",\"trainNo\":\"012183\",\"ciCode\":\"55012183\",\"sectionPercent\":51,\"arriveSeconds\":97},{\"lineCode\":150,\"sectionCode\":\"15013-15012\",\"trainNo\":\"021187\",\"ciCode\":\"55021187\",\"sectionPercent\":100,\"arriveSeconds\":0}]},{\"timeStamp\":61200,\"trainInfoList\":[{\"lineCode\":150,\"sectionCode\":\"15020-15018\",\"trainNo\":\"052190\",\"ciCode\":\"55052190\",\"sectionPercent\":9,\"arriveSeconds\":92},{\"lineCode\":150,\"sectionCode\":\"15007-15006\",\"trainNo\":\"071182\",\"ciCode\":\"55071182\",\"sectionPercent\":100,\"arriveSeconds\":0}]}]\n";
        List<Map<String, Object>> mapList = JSON.parseObject(str, new TypeReference<List<Map<String, Object>>>() {});
        return mapList;
    }

}
