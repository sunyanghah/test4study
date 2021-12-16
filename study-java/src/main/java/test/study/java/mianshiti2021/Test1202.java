package test.study.java.mianshiti2021;

import com.alibaba.fastjson.JSON;

import java.net.InetAddress;

/**
 * @author sunYang
 * @date 2021/12/2 17:20
 */
public class Test1202 {

    public static void main(String[] args) throws Exception{
        InetAddress address = InetAddress.getLocalHost();//获取的是本地的IP地址 //PC-20140317PXKX/192.168.0.121
        String hostAddress = address.getHostAddress();
        System.out.println(hostAddress);


        String s = JSON.toJSONString("12312");
        System.out.println("------------------");
        System.out.println(s);

    }


}
