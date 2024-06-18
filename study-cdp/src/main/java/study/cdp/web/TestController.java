package study.cdp.web;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;

/**
 * @author sun yang
 * @date 2024/3/8
 */
@RestController
@RequestMapping("/chrome")
public class TestController {

    private ChromeDriver webDriver;

    @GetMapping("/start")
    public void start(String userId){

        // TODO 拿到userId,维护userId与agent(隔离节点)关系
        // TODO user-data-dir的根目录从agent配置文件里拿

        // 谷歌驱动
        ChromeOptions options = new ChromeOptions();
        // 允许所有请求
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--remote-debugging-port=0");
        options.addArguments("--remote-debugging-pipe");
        options.addArguments("--user-data-dir=C:\\cdp_user_data");

        webDriver = new ChromeDriver(options);

        System.out.println("端口是===="+getPort());

        // 启动需要打开的网页
//        webDriver.get("http://www.baidu.com");
//        System.out.println("--====--打完收工");
//        webDriver.quit();
    }

    private String getPort(){
        Object capability = webDriver.getCapabilities().getCapability("goog:chromeOptions");
        if (capability != null){
            Map<String,String> addressMap = (Map)capability;
            String debuggerAddress = addressMap.get("debuggerAddress");
            if (debuggerAddress != null) {
                return debuggerAddress.split(":")[1];
            }
        }
        return null;
    }

    @GetMapping("/check")
    public void check(){
        if (webDriver == null){
            System.out.println("程序还没启动。。。");
            return;
        }
        try {
            Set<String> windowHandles = webDriver.getWindowHandles();
        }catch (Exception e){
            System.out.println("程序退出了。。。。。。。。。。");
            return;
        }

        // 输出脚本执行结果
        System.out.println("程序没有退。。。端口是"+getPort());
    }

}
