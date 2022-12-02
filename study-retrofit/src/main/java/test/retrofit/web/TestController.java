package test.retrofit.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import test.retrofit.client.TestClient;
import test.retrofit.config.RP;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author sunYang
 * @date 2022/7/22 16:32
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private TestClient testClient;

    /**
     * 登录 返回token
     * @return
     */
    @GetMapping("/login")
    public RP test() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("loginName","admin");
        hashMap.put("password","admin");
        RP<String> result = testClient.login(hashMap);
        System.out.println(result);
        return result;
    }

    /**
     * token 请求头
     * @param token
     * @return
     */
    @GetMapping("/type")
    public RP testType(@RequestParam("token")String token){

        RP componentType = testClient.getComponentType(token);
        return componentType;

    }

}
