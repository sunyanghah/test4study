package test.study.java.mianshiti2023;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunYang
 * @date 2023/2/17 16:30
 */
public class Test0217 {

    public static void main(String[] args) throws Exception{

        String demo = "{\"名称\":\"机柜测试名称\",\"所属\":\"Floor1-Building1-Datacenter6996_JF\",\"_DATAFROM_\":\"WEBEDIT\",\"设备型号\":\"通用 800宽_标准服务器机柜\",\"_DATASOURCES_\":\"WEBEDIT\",\"编号\":\"机柜模拟测试\",\"_OFFSET_\":\"[-5.6,0,-16.1]\"}";
        Map<String,String> demoMap = JSON.parseObject(demo, Map.class);

        List<Map> mapList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Map map = new HashMap();
            map.put("名称",demoMap.get("名称")+i);
            map.put("编号",demoMap.get("编号")+i);
            map.put("所属",demoMap.get("所属"));
            map.put("_DATAFROM_",demoMap.get("_DATAFROM_"));
            map.put("设备型号",demoMap.get("设备型号"));
            map.put("_DATASOURCES_",demoMap.get("_DATASOURCES_"));
            map.put("_OFFSET_",demoMap.get("_OFFSET_"));
            mapList.add(map);
        }

        System.out.println(JSON.toJSONString(mapList));

    }

}
