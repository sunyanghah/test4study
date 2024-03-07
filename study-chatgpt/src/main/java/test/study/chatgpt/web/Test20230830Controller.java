package test.study.chatgpt.web;

import org.springframework.web.bind.annotation.*;
import test.study.chatgpt.config.ApiResult;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author sunYang
 * @date 2023/8/30 15:37
 */
@RestController
@RequestMapping("/twin")
public class Test20230830Controller {

    Integer status = 2;

    @PostMapping("/offlineDeploy/queryPage")
    public ApiResult<Map> queryPage(@RequestBody Map map){
        Map m1 = new HashMap<>();
        m1.put("id",10000003);
        m1.put("name","部署包名称1");
        m1.put("status",status);
        m1.put("version","4.6.0");
        m1.put("url","");
        m1.put("message","");
        m1.put("createTime","2023-08-30 16:18:00");
        Map m2 = new HashMap<>();
        m2.put("id",10000002);
        m2.put("name","部署包名称1");
        m2.put("status",3);
        m2.put("version","4.6.0");
        m2.put("url","");
        m2.put("message","");
        m2.put("createTime","2023-08-30 16:17:00");
        Map m3 = new HashMap<>();
        m3.put("id",10000001);
        m3.put("name","部署包名称1");
        m3.put("status",4);
        m3.put("version","4.6.0");
        m3.put("url","");
        m3.put("message","啊我失败啦");
        m3.put("createTime","2023-08-30 16:16:00");

        List<Map> mapList = new ArrayList<>();
        for(int i=0;i< 10;i++){
            Map m = new HashMap<>();
            m.put("id",2000000+i);
            m.put("name","部署包名称1");
            m.put("status",4);
            m.put("version","4.6.0");
            m.put("url","");
            m.put("message","啊我失败啦");
            m.put("createTime","2023-08-30 16:16:00");
            mapList.add(m);
        }
//        mapList.add(m1);
//        mapList.add(m2);
//        mapList.add(m3);
        Map<String,Object> pageMap = new HashMap<>();
        pageMap.put("pageNum",1);
        pageMap.put("pageSize",10);
        pageMap.put("totalRows",3);
        pageMap.put("totalPages",1);
        pageMap.put("data",mapList);


        return ApiResult.success(pageMap);
    }

    @GetMapping("/offlineDeploy/getStatus")
    public ApiResult getStatus(@RequestParam("id")Integer id) throws Exception{
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2023-08-30 16:26:00");
        if (System.currentTimeMillis() > date.getTime()){
            status = 3;
            return ApiResult.success(3);
        }
        return ApiResult.success(2);
    }

}
