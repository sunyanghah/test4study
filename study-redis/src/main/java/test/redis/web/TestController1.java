package test.redis.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dell on 2020/7/12.
 * @author dell
 */
@RestController
public class TestController1 {

    @Autowired
    private RedisTemplate redisTemplate;


    @GetMapping("/test1")
    public void test1(){
        redisTemplate.opsForValue().set("testKey1","testValue1");
        redisTemplate.opsForValue().set("testKey2","testValue2");
        redisTemplate.opsForValue().set("testKey3","testValue3");
        redisTemplate.opsForValue().set("testKey4","testValue4");

        System.out.println(redisTemplate.opsForValue().get("testKey1"));
        System.out.println(redisTemplate.opsForValue().get("testKey2"));
        System.out.println(redisTemplate.opsForValue().get("testKey3"));
        System.out.println(redisTemplate.opsForValue().get("testKey4"));
    }


}
