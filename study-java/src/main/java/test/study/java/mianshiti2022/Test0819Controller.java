package test.study.java.mianshiti2022;

import com.alibaba.fastjson.JSON;

import java.util.Map;

/**
 * @author sunYang
 * @date 2022/8/19 18:50
 */
public class Test0819Controller {

    public static void main(String[] args) {
        String str = "{\"id\": \"8248425777951596544\", \"main\": \"frame.js\", \"name\": \"gh\", \"type\": \"plugin\", \"author\": \"\", \"version\": \"1.0.1\", \"external\": {\"standard\": \"Revision\", \"thingjs-x\": {\"date\": \"2022/8/19 11:36:32\", \"extend\": {}, \"license\": \"北京优锘科技有限公司 版权所有\", \"plugin-type\": \"core\"}, \"use-standard\": \"0\", \"encrypt-files\": [\"frame.js\"]}, \"dependencies\": {\"thingjs\": \"1.2.7.17\", \"dpdVersion\": \">1.0.2 <=2.3.4\"}}";

        Map map = JSON.parseObject(str, Map.class);

        Object dependencies = map.get("dependencies");

        Map depMap = JSON.parseObject(dependencies.toString(), Map.class);

        System.out.println("----");

    }

}
