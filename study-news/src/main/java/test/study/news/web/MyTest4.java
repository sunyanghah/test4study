package test.study.news.web;

import com.alibaba.fastjson.JSON;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dell on 2019/7/4.
 */
public class MyTest4 {

    private static Pattern pattern = Pattern.compile("ether (.+[^ ])(?: )*txqueuelen");
    public static void main(String[] args) throws Exception{
        test4();
    }

    public static void test1() throws Exception{
        String str = "\"{\"Containers\":\"N/A\",\"CreatedAt\":\"2019-07-10 23:36:07 +0\n" +
                "800 CST\",\"CreatedSince\":\"4 weeks ago\",\"Digest\":\"\\u003cnone\\u003e\",\"ID\":\"c239578468bb\",\"Repository\":\"prom/prometheus\",\"SharedSize\":\"N/A\",\"Size\":\"126MB\",\"Tag\":\"latest\",\"UniqueSize\":\"\n" +
                "N/A\",\"VirtualSize\":\"125.7MB\"}\"";
        str = str.substring(1,str.length()-1);
        Map<String,Object> map = JSON.parseObject(str,Map.class);
        System.out.println(map);
    }

    public static void test2() throws Exception{
        String str = "ens39: flags=4163<UP,BROADCAST,RUNNING,MULTICAST>  mtu 1500\n" +
                "        inet6 fe80::c5da:a6f0:b7fe:fdce  prefixlen 64  scopeid 0x20<link>\n" +
                "         txqueuelen 1000  (Ethernet)\n" +
                "        RX packets 0  bytes 0 (0.0 B)\n" +
                "        RX errors 0  dropped 0  overruns 0  frame 0\n" +
                "        TX packets 1144  bytes 205392 (200.5 KiB)\n" +
                "        TX errors 0  dropped 0 overruns 0  carrier 0  collisions 0\n";

        Matcher matcher = pattern.matcher(str);
        if (matcher.find()){
            System.out.print("---"+matcher.group(1)+"---");
        }
    }

    public static void test3() throws Exception{
        List list = Arrays.asList("docker","image","ls");
        list.add("--all");
        System.out.println(list);
    }

    public static void test4() throws Exception{
        List<String> list = new ArrayList<>(Arrays.asList("docker","image","ls"));
        list.add("--all");
        list.add("--format");
        System.out.println(list.size());
        System.out.println("------------");
        for (String s:list.toArray(new String[list.size()])){
            System.out.println(s);
        }
    }



}
