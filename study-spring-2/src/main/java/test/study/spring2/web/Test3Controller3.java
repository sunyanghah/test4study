package test.study.spring2.web;

import com.alibaba.fastjson.JSON;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunYang
 * @date 2023/2/16 13:58
 */
public class Test3Controller3 {



    public static void main(String[] args) throws Exception{

        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> params = new HashMap<>();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        String fetchUrl = "http://10.100.40.15:8001/study-spring/test0216";
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        HttpClientResult httpClientResult = HttpClientUtils.doPost(fetchUrl, headers, params, "STRING");
        if (httpClientResult.getCode() == 200) {
            String content = httpClientResult.getContent();
            List<FinalPerformanceDTO> finalPerformanceDTOS = JSON.parseArray(content, FinalPerformanceDTO.class);
            System.out.println(finalPerformanceDTOS);
        } else {
            System.out.println("fetchMonitor by URL [{}] is wrong, return code is [{}], return content is [{}]"+ fetchUrl+httpClientResult.getCode()+ httpClientResult.getContent());
        }

    }

}
