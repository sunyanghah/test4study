package test.study.java.mianshi2020;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author sunYang
 * @Date 2020/9/4
 */
public class Test0904 {

    public static void main(String[] args) throws Exception{
       test2();
    }

    private static void test1(){
        String str = "[[100,100],[100,200],[200,200],[200,150],[100,100]]";
        String str2 = "[[100, 100], [100, 200], [200, 200], [200, 150], [100, 100]]";
        System.out.println(JSON.parseObject(str2,Double[][].class));
    }

    private static void test2() throws Exception{
        Double[][] arr = new Double[2][2];
        arr[0][0] = 1.1;
        arr[0][1] = 1.1;
        arr[1][0] = 1.1;
        arr[1][1] = 1.1;

        System.out.println(JSON.toJSONString(arr));
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(arr));

    }

}
