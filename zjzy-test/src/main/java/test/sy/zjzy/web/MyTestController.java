package test.sy.zjzy.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dell on 2019/6/26.
 * @author dell
 */
@RestController
@Slf4j
public class MyTestController {


    @GetMapping("/netip")
    public Map<String,Object> getIpTest() throws Exception{

        log.info("request again --------------------------------------------------------------------");
        Enumeration<NetworkInterface> nifs = NetworkInterface.getNetworkInterfaces();
        while (nifs.hasMoreElements()) {
            NetworkInterface nif = nifs.nextElement();
            // 获得与该网络接口绑定的 IP 地址，一般只有一个
            Enumeration<InetAddress> addresses = nif.getInetAddresses();
            log.info("网卡接口名称----：{}" , nif.getName());
            while (addresses.hasMoreElements()) {
                InetAddress addr = addresses.nextElement();
                if (addr instanceof Inet4Address) { // 只关心 IPv4 地址
                    log.info("网卡接口地址+++=：{}" , addr.getHostAddress());
                }
            }
        }

        Map<String,Object> map = new HashMap<>();
        map.put("result","success");
        return map;
    }



}
