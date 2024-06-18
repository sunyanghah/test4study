package study.cdp.web;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Map;

/**
 * @author sun yang
 * @date 2024/3/18
 */
public class Test3 {

    private static ChromeDriver webDriver;

    private static ChromeDriverService chromeDriverService;

    public static void main(String[] args) {

        // 谷歌驱动
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--remote-debugging-address=0.0.0.0");
        options.addArguments("--remote-debugging-pipe");
        options.addArguments("--headless");

        options.addArguments("--remote-debugging-port=0");

        options.addArguments("--user-data-dir=C:\\cdp_user_data\\2");

        ChromeDriverService.Builder builder = new ChromeDriverService.Builder();
        chromeDriverService = builder.build();

        webDriver = new ChromeDriver(chromeDriverService, options);

        System.out.println("----------"+getPort());

//        webDriver.quit();
    }

    public static String getPort(){
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

}
