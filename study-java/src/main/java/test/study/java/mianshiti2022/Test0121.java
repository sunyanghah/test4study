package test.study.java.mianshiti2022;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sunYang
 * @date 2022/1/21 18:33
 */
public class Test0121 {

    public static void main(String[] args) throws Exception{
        String filePath = "C:\\xxv\\file\\staticResource\\testCarData";

        File dirFile = new File(filePath);
        File[] files = dirFile.listFiles();

        BufferedWriter bw = null;
        BufferedReader br = null;

        for (File file : files) {
            System.out.println("-----"+file.getName());
            StringBuilder sb = new StringBuilder();
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String str = br.readLine();
            while (str != null){
                sb.append(str);
                str = br.readLine();
            }
            Map<String, Object> map = JSON.parseObject(sb.toString(), new TypeReference<Map<String, Object>>() {});

            Map<String,Object> newMap = new HashMap<>();
            newMap.put("className","列车");
            newMap.put("ciPerformanceList",map.get("trainInfoList"));

            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            bw.write(JSON.toJSONString(newMap));
            bw.flush();

        }
        bw.close();
        br.close();

    }

}
