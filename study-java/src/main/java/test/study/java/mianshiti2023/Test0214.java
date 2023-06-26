package test.study.java.mianshiti2023;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author sunYang
 * @date 2023/2/14 11:30
 */
public class Test0214 {

    public static void main(String[] args) {

        Map map = new HashMap();
        map.put("resourceId","abc");

        Map map2 = new HashMap();
        map2.put("resourceId","222");
        List<Map<String,String>> resources = new ArrayList<>();
        resources.add(map);
        resources.add(map2);

        String resourceId1 = resources.stream()
                .map(resource -> resource.get("resourceId"))
                .filter(StringUtils::hasText)
                .collect(Collectors.joining(","));

        System.out.println(resourceId1);
    }

}
