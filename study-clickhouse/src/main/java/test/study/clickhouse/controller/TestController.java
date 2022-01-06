package test.study.clickhouse.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import test.study.clickhouse.config.ApiResult;
import test.study.clickhouse.dto.ClassDto;
import test.study.clickhouse.dto.ClassStudentDto;
import test.study.clickhouse.service.TestService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sunYang
 * @date 2022/1/6 16:46
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private TestService testService;

    @GetMapping
    public ApiResult testQuery(){

        List<ClassDto> classDtoList = testService.testQuery();

        return ApiResult.success(classDtoList);
    }

    @GetMapping("/test2")
    public ApiResult testQuery2(){

        List<ClassStudentDto> dtoList = testService.testQuery2();

        return ApiResult.success(dtoList);
    }
    @PutMapping("/test3")
    public ApiResult testEdit(@RequestBody @Validated ClassDto classDto){

        testService.testEdit(classDto);

        return ApiResult.success();
    }

    @PostMapping("/testAdd")
    public ApiResult testAdd(@RequestBody @Validated ClassDto classDto){
        String classId = testService.testAdd(classDto);
        return ApiResult.success(classId);
    }

}
