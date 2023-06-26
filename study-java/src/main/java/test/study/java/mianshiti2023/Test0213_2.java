package test.study.java.mianshiti2023;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.util.IOUtils;

import java.io.*;
import java.util.HashMap;

/**
 * @author sunYang
 * @date 2023/2/13 18:44
 */
public class Test0213_2 {

    public static void main(String[] args) throws Exception{

        File jsonFile = new File("C:\\Users\\Admin\\Desktop\\20230213\\response5.json");
        String jsonObj = readFile(jsonFile);

        HashMap hashMap = JSON.parseObject(jsonObj, HashMap.class);
        String data = hashMap.get("data").toString();

        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Admin\\Desktop\\20230213\\unknown5.zip");

        byte[] bytes = IOUtils.decodeBase64(data);

        fileOutputStream.write(bytes);
        fileOutputStream.flush();


    }

    private static String readFile(File file){
        FileInputStream fis = null;
        BufferedReader br = null;

        try {
            fis = new FileInputStream(file);
            br = new BufferedReader(new InputStreamReader(fis,"UTF-8"));

            return br.readLine();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (fis != null){
                    fis.close();
                }
                if (br != null){
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return "";
    }

}
