package study.cdp.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

/**
 * @author sun yang
 * @date 2024/3/7
 */
public class Test {

    /**
     * 端口，让chrome自己找一个能用的，读文件拿到端口返回。
     * 用户数据位置：根据用户ID做文件夹区分。
     * agent不用启动标签页，让客户端自己启。
     * 不用管怎么停止
     * 如果客户端与渲染服务连接中断了，会发生什么？重新连？
     * agent怎么判断渲染服务已经停止，判断Local State文件的 last_active_profiles?
     *
     * C端应用怎么实现
     * @param args
     */

    public static void main(String[] args) {
        test1();
    }

    /**
     * chromeDriver在环境变量中，不需要显示设置位置
     */
    private static void test(){
        // 谷歌驱动
        ChromeOptions options = new ChromeOptions();
        // 允许所有请求
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--remote-debugging-port=0");
        options.addArguments("--remote-debugging-pipe");
        options.addArguments("--user-data-dir=C:\\cdp_user_data\\2");

        WebDriver webDriver = new ChromeDriver(options);

        // 启动需要打开的网页
//        webDriver.get("http://www.baidu.com");
//        System.out.println(webDriver.toString());
        System.out.println("--====--打完收工");
//        webDriver.quit();
    }


    /**
     * 指定chromedriver文件位置
     */
    private static void test1(){
        // 谷歌驱动
        ChromeOptions options = new ChromeOptions();
        // 允许所有请求
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--remote-debugging-port=0");
        options.addArguments("--remote-debugging-pipe");
        options.addArguments("--user-data-dir=C:\\cdp_user_data\\2");

        ChromeDriverService.Builder builder = new ChromeDriverService.Builder();
        builder.usingDriverExecutable(new File("D:\\JAVA\\JDK1.8\\bin\\chromedriver.exe"));
        ChromeDriverService chromeDriverService = builder.build();
        System.out.println("1111"+chromeDriverService.isRunning());
        WebDriver webDriver = new ChromeDriver(chromeDriverService,options);
        System.out.println("2222"+chromeDriverService.isRunning());
    }

    /**
     * 指定chromedriver文件位置
     */
    private static void test2(){
        // 谷歌驱动
        ChromeOptions options = new ChromeOptions();
        // 允许所有请求
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--remote-debugging-port=0");
        options.addArguments("--remote-debugging-pipe");
        options.addArguments("--user-data-dir=C:\\cdp_user_data\\2");

        System.setProperty("webdriver.chrome.driver","D:\\JAVA\\JDK1.8\\chromedriver.exe");

        WebDriver webDriver = new ChromeDriver(options);
    }

    private static void test3(){
        try {
            // 谷歌驱动
            ChromeOptions options = new ChromeOptions();
            // 允许所有请求
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--remote-debugging-port=0");
            options.addArguments("--remote-debugging-pipe");
            options.addArguments("--user-data-dir=C:\\cdp_user_data\\2");

            options.setBinary(new File("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"));

            WebDriver webDriver = new ChromeDriver(options);

            // 启动需要打开的网页
            System.out.println("--====--打完收工，正常");
        }catch (Exception e){
            System.out.println("-----还是异常");
        }
    }

}
