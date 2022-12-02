package study.mysql.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.mysql.config.RP;
import study.mysql.service.IFieldInfoService;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dell
 * @since 2020-12-18
 */
@RestController
@RequestMapping("/fieldInfo")
public class FieldInfoController {

    @Resource
    private IFieldInfoService fieldInfoService;

    @GetMapping("/init")
    public RP init(){

        fieldInfoService.init();

        return RP.buildSuccess(null);
    }

}
