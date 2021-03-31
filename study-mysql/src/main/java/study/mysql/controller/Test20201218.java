package study.mysql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.mysql.config.RP;
import study.mysql.service.InitDataService;

import javax.annotation.Resource;

/**
 * @author sunYang
 * @Date 2020-12-18
 */
@RestController
@RequestMapping("/test20201218")
public class Test20201218 {

    @Resource
    private InitDataService initDataService;

    @GetMapping("/init-data")
    private RP initData(){
        initDataService.initData();
        return RP.buildSuccess("");
    }

}
