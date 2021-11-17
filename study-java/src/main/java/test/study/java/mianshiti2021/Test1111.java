package test.study.java.mianshiti2021;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.List;

/**
 * @author sunYang
 * @date 2021/11/11 15:58
 */
public class Test1111 {

    public static void main(String[] args) {
        String coordinateStr = "[[100,200],[300,400]]";
        List<List<Double>> coordinate = JSON.parseObject(coordinateStr, new TypeReference<List<List<Double>>>() {
        });
        System.out.println(coordinate);
    }

}
