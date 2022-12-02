package test.stomp3.controller;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import test.stomp3.dto.Student;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

/**
 * @author sunYang
 * @date 2022/6/16 15:11
 */
@RestController
@RequestMapping("/test0616")
@Slf4j
public class Test0616Controller {

    @PostMapping
    public void test(@RequestBody @Validated List<Student> student){
        System.out.println(student);
    }

    @PostMapping("/tt")
    public void testtt(Te map){

        System.out.println(JSON.toJSONString(map));

    }

    @GetMapping("/ip")
    public void testGetIp(){
        log.info("----------"+getLocalIP());
    }

    public static String getLocalIP() {
        String localIP = "127.0.0.1";
        try {
            OK:
            for (Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces(); interfaces.hasMoreElements(); ) {
                NetworkInterface networkInterface = interfaces.nextElement();
                if (networkInterface.isLoopback() || networkInterface.isVirtual() || !networkInterface.isUp()) {
                    continue;
                }
                Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress address = addresses.nextElement();
                    if (address instanceof Inet4Address) {
                        localIP = address.getHostAddress();
                        break OK;
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return localIP;
    }

    @Data
    public static class Te{
        private String name;
    }

}
