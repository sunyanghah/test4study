package study.slowsql2.web;

import com.alibaba.druid.stat.DruidStatManagerFacade;
import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.slowsql2.service.TestService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author sunYang
 * @date 2023/1/5 17:17
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private TestService testService;

    @GetMapping
    public void test(){
        testService.test();
    }

    @GetMapping("druid")
    public List<Map<String, Object>> testDruid(){
        DruidStatManagerFacade instance = DruidStatManagerFacade.getInstance();
        return instance.getDataSourceStatDataList();
    }

}
