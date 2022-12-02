package study.license.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.license.util.CpuUtil;
import study.license.util.MacUtil;
import study.license.util.MainBordUtil;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sunYang
 * @date 2021/12/2 17:48
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Value("${my.env.desc}")
    private String desc;

//    @GetMapping
//    public Map<String,String> test() throws Exception{
//        InetAddress address = InetAddress.getLocalHost();
//        String hostAddress = address.getHostAddress();
//
//        String cpuId = CpuUtil.getCPUId();
//        String mac = MacUtil.getMAC();
//        String mainBordId = MainBordUtil.getMainBordId();
//
//        Map<String,String> map = new HashMap<>();
//        map.put("data",hostAddress+"#######################"+cpuId+"########"+mac+"#############"+mainBordId);
//        return map;
//    }

    @GetMapping
    public String test(){
        log.info("-----------------"+desc);
        return desc;
    }


}
