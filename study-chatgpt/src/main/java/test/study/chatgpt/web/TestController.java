package test.study.chatgpt.web;

import com.plexpt.chatgpt.ChatGPT;
import com.plexpt.chatgpt.util.Proxys;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sunYang
 * @date 2023/6/28 16:51
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @PostMapping
    public Map<String,String> test(@RequestBody Map<String,String> map){
        String req = map.get("req");
        Proxy proxy = Proxys.http("127.0.0.1", 7890);
        ChatGPT chatGPT = ChatGPT.builder()
                .apiKey("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")
                .proxy(proxy)
                .apiHost("https://api.openai.com/") //反向代理地址
                .build()
                .init();

        String res = chatGPT.chat(req);
        System.out.println(res);
        Map result = new HashMap();
        result.put("res",res);
        return result;
    }

}
