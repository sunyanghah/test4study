package test.study.spring1.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author sunYang
 * @date 2023/2/16 11:16
 */
@RestController
@RequestMapping("/test0216")
@Slf4j
public class Test0216 {

    @PostMapping
    public List<Map> test(@RequestBody Map map){
        String result = "[{\"val\":9999999,\"unit\":\"度\",\"kpiName\":\"开关状态\",\"ciName\":\"B6_YQ02021015\"}]";
        return JSON.parseObject(result,new TypeReference<List<Map>>() {});
    }

    @Scheduled(cron = "0 0/1 * * * ?")
    public void test(){
        log.info("dsssssssssssssssssssssssssssssssssssssssssssssssssssss");
    }

    @Scheduled(cron = "0 * * * * ?")
    public void test2(){
        log.info("tttttttttttttttttttttttttttttttttttttttttttttttttttttt");
    }

}
