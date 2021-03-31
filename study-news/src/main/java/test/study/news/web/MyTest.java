package test.study.news.web;

import com.alibaba.fastjson.JSON;
import org.springframework.util.StringUtils;
import test.study.common.exception.BusinessException;

import java.io.*;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dell on 2019/6/26.
 */
public class MyTest {

    public static void main(String[] args) throws Exception{
        System.out.println("REPOSITORY              TAG                 IMAGE ID            CREATED             SIZE".replaceAll(" ",""));
        test13();
    }


    public static void test1() throws Exception{
        Enumeration<NetworkInterface> nifs = NetworkInterface.getNetworkInterfaces();
        while (nifs.hasMoreElements()) {
            NetworkInterface nif = nifs.nextElement();
            // 获得与该网络接口绑定的 IP 地址，一般只有一个
            Enumeration<InetAddress> addresses = nif.getInetAddresses();
            System.out.println("网卡接口名称----：" + nif.getName());
            while (addresses.hasMoreElements()) {
                InetAddress addr = addresses.nextElement();
                if (addr instanceof Inet4Address) { // 只关心 IPv4 地址
                    System.out.println("网卡接口地址+++=：" + addr.getHostAddress());
                    System.out.println();
                }
            }
        }
    }

    public static void test2() throws Exception{
        Process process = Runtime.getRuntime().exec("ipconfig");
        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(),"GBK"));
        for (String str = br.readLine();str != null;){
            System.out.println(str);
            str = br.readLine();
        }
    }
    public static Pattern patternName = Pattern.compile("(.+)(?:: ){1}");
    public static Pattern patternFlag = Pattern.compile("flags=(?:\\d+)<(.+?)>");
    public static Pattern patternIp = Pattern.compile("inet (.+[^ ])(?: )*netmask");
    public static Pattern patternNetmask = Pattern.compile("netmask (.+[^ ])(?: )*broadcast");
    public static Pattern patternBroadcast = Pattern.compile("broadcast (.+[^ ])(?: )*inet6");

    public static void test3() throws Exception{
        String str = "ens32: flags=4163<UP,BROADCAST,RUNNING,MULTICAST>  mtu 1500\n" +
                "        inet 192.168.1.194  netmask 255.255.255.0  broadcast 192.168.1.255\n" +
                "        inet6 fe80::6fdd:a448:9b6c:594d  prefixlen 64  scopeid 0x20<link>\n" +
                "        ether 00:17:2a:e7:77:08  txqueuelen 1000  (Ethernet)\n" +
                "        RX packets 870  bytes 73502 (71.7 KiB)\n" +
                "        RX errors 0  dropped 0  overruns 0  frame 0\n" +
                "        TX packets 356  bytes 51992 (50.7 KiB)\n" +
                "        TX errors 0  dropped 0 overruns 0  carrier 0  collisions 0\n" +
                "        device interrupt 16  memory 0xfe6e0000-fe700000  \n" +
                "\n" +
                "ens33: flags=4099<UP,BROADCAST,MULTICAST>  mtu 1500\n" +
                "        ether 00:17:2a:e7:77:09  txqueuelen 1000  (Ethernet)\n" +
                "        RX packets 0  bytes 0 (0.0 B)\n" +
                "        RX errors 0  dropped 0  overruns 0  frame 0\n" +
                "        TX packets 0  bytes 0 (0.0 B)\n" +
                "        TX errors 0  dropped 0 overruns 0  carrier 0  collisions 0\n" +
                "        device interrupt 17  memory 0xfe7e0000-fe800000  \n";
        Matcher matcher = patternName.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }

        System.out.println("-----------------------");
        Matcher matcher2 = patternFlag.matcher(str);
        while (matcher2.find()){
            System.out.println(matcher2.group(1));
        }

        System.out.println("-----------------------");
        Matcher matcher3 = patternIp.matcher(str);
        while (matcher3.find()){
            System.out.println(matcher3.group(1));
        }

        System.out.println("-----------------------");
        Matcher matcher4 = patternNetmask.matcher(str);
        while (matcher4.find()){
            System.out.println(matcher4.group(1));
        }

        System.out.println("-----------------------");
        Matcher matcher5 = patternBroadcast.matcher(str);
        while (matcher5.find()){
            System.out.println(matcher5.group(1));
        }
    }


    public static Pattern patternIpAddr = Pattern.compile("IPADDR=(\\S+)",Pattern.CASE_INSENSITIVE);
    public static Pattern patternYes = Pattern.compile("'yes'",Pattern.CASE_INSENSITIVE);
    private static void test4(){
        String str = "ONBOOT='yes\n" +
                "IPADDR= \"192.168.1.193\"\n" +
                "IPADDR=\"192.168.1.192\"\n" +
                "NETMASK=\"255.255.255.0\"";

        Matcher matcher = patternIpAddr.matcher(str);
        if (matcher.find()){
            System.out.println(patternYes.matcher(matcher.group(1)).find());
            System.out.println(matcher.group(1));
        }


    }

    public static String[] charList = new String[]{"\"","'",""};

    public static boolean test5(String regex,String str) throws Exception{
        StringBuilder sb ;
        for (String character : charList){
            sb = new StringBuilder();
            sb.append(character).append(regex).append(character);
            if (str.equalsIgnoreCase(sb.toString())){
                return true;
            }
        }
        return false;
    }


    public static void test6() throws Exception{
        String str = "TYPE=\"Ethernet\"BOOTPROTO=\"static\"DEFROUTE=\"yes\"PEERDNS=\"yes\"PEERROUTES=\"yes\"IPV4_FAILURE_FATAL=\"no\"IPV6INIT=\"yes\"IPV6_AUTOCONF=\"yes\"IPV6_DEFROUTE=\"yes\"IPV6_PEERDNS=\"yes\"IPV6_PEERROUTES=\"yes\"IPV6_FAILURE_FATAL=\"no\"IPV6_ADDR_GEN_MODE=\"stable-privacy\"NAME=\"ens33\"UUID=\"2fd316f1-b139-4611-8263-87ab69f47a92\"DEVICE=\"ens33\"ONBOOT=\"yes\"IPADDR=\"192.168.1.190\"NETMASK=\"255.255.255.0\"";
    }

    public static void test7() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("f:/szyx/temp/a.txt")));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("f:/szyx/temp/a.txt")));
        Map<String,String> map = new HashMap<>();
        map.put("NAME","zhangsan");
        map.put("AGE","55");
        for (Map.Entry<String,String> entry : map.entrySet()){
            bw.write(entry.getKey()+"="+entry.getValue());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static Pattern patternKey = Pattern.compile("(\\S+?)=");
    static Pattern patternValue = Pattern.compile("=(\\S+)");

    public static void test8() throws Exception{
        String str = "TYPE=\"Ethernet=fff\"";
        Matcher matcher = patternKey.matcher(str);
        if (matcher.find()){
            System.out.println(matcher.group(1));
        }

        Matcher matcherValue = patternValue.matcher(str);
        if (matcherValue.find()) {
            System.out.println(matcherValue.group(1));
        }
    }


    public static void test9() throws Exception{
        System.out.println("sabf"+(1+2));
    }

    public static void test10() throws Exception{
        String str = "1.41,0.00";
        System.out.println(str.split(",").length);
        for (String s : str.split(",")){
            System.out.println(s);
            System.out.println(Double.parseDouble(s));
        }
    }

    public static Map<String,String> handleConfigToMap(File file) throws Exception{
        if (file.exists()) {
            Map<String, String> map = new HashMap<>();
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            for (String str = br.readLine(); str != null; ) {
                if (str.contains(" ")) {
                    throw new BusinessException("错误的配置格式");
                }
                String key = getOneRegexByPattern(patternKey, str);
                if (StringUtils.isEmpty(key)) {
                    throw new BusinessException("错误的配置格式");
                }
                if (!map.containsKey(key)) {
                    map.put(key, getOneRegexByPattern(patternValue, str));
                }
                str = br.readLine();
            }
        }
        return null;
    }

    public static String getOneRegexByPattern(Pattern pattern,String str) throws Exception{
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()){
            return matcher.group(1);
        }
        return null;
    }

    private static void test12(String patternStr,String str){
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()){
            System.out.println(matcher.group(1));
        }
    }

    private static void test13() {
        String str = "";
        String[] arr = str.split(",");
        System.out.println(arr);

        String text = "CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS              PORTS                               NAMES\n" +
                "393690952ac7        mysql               \"docker-entrypoint.s…\"   4 seconds ago       Up 3 seconds        3306/tcp, 33060/tcp                 \\nmysql_container_sdfsdfsdfsdfdsssssssssssssssssssssssssssssfsddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd\n" +
                "0fc95718e444        mysql               \"docker-entrypoint.s…\"   4 hours ago         Up 4 hours          0.0.0.0:3306->3306/tcp, 33060/tcp   mysql_container\n";
        String[] textArr = text.split("\n");
        System.out.println(textArr.length);
        for (String textLine : textArr){
            String[] lineArr = textLine.split("(  )+");
            System.out.println(lineArr);
        }

    }

}
