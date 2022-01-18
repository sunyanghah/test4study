package test.study.java.mianshiti2022;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author sunYang
 * @date 2022/1/11 17:16
 */
public class Test0111_2 {

    public static void main(String[] args) throws Exception {
        String filePath = "D:\\uino\\北京地铁交控\\客户提供数据\\0108线站区间\\列车数据3\\trainPos_1_12";

        File dirFile = new File(filePath);
        File[] files = dirFile.listFiles( (dir,name) -> {
            String fileName = name.substring(0, name.lastIndexOf("."));
            if (Integer.parseInt(fileName) > 18000) {
                return true;
            }
            return false;
        });

        List<File> fileList = Arrays.asList(files);

        Collections.sort(fileList,(f1,f2) -> {
            Integer f1Name = Integer.parseInt(f1.getName().substring(0, f1.getName().lastIndexOf(".")));
            Integer f2Name = Integer.parseInt(f2.getName().substring(0, f2.getName().lastIndexOf(".")));

            return f1Name.compareTo(f2Name);
        });


        for (File file : fileList) {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String str = br.readLine();
            StringBuilder sb = new StringBuilder();
            while(str != null){
                sb.append(str);
                str = br.readLine();
            }
            if (sb.length() == 0){
                continue;
            }
            interfaceUtil("http://localhost:1995/customer/rest/uinv/performance",sb.toString());
            Thread.sleep(5000);
        }

    }

    public static void interfaceUtil(String path,String data) {
        try {
            URL url = new URL(path);
            //打开和url之间的连接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            PrintWriter out = null;
            //请求方式
            conn.setRequestMethod("POST");
//           //设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("content-type","application/json");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            //设置是否向httpUrlConnection输出，设置是否从httpUrlConnection读入，此外发送post请求必须设置这两个
            //最常用的Http请求无非是get和post，get请求可以获取静态页面，也可以把参数放在URL字串后面，传递给servlet，
            //post与get的 不同之处在于post的参数不是放在URL字串里面，而是放在http请求的正文内。
            conn.setDoOutput(true);
            conn.setDoInput(true);
            //获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            //发送请求参数即数据
            out.print(data);
            //缓冲数据
            out.flush();
            //获取URLConnection对象对应的输入流
            InputStream is = conn.getInputStream();
            //构造一个字符流缓存
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String str = "";
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }
            //关闭流
            is.close();
            //断开连接，最好写上，disconnect是在底层tcp socket链接空闲时才切断。如果正在被其他线程使用就不切断。
            //固定多线程的话，如果不disconnect，链接会增多，直到收发不出信息。写上disconnect后正常一些。
            conn.disconnect();
            System.out.println("完整结束");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
