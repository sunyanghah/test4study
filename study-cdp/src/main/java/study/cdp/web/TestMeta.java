package study.cdp.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

/**
 * @author sun yang
 * @date 2024/3/20
 */
public class TestMeta {

    public static void main(String[] args) {
        test3();
    }


    private static void test3(){
        try {
            // 谷歌驱动
            ChromeOptions options = new ChromeOptions();
            // 允许所有请求
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--remote-debugging-address=0.0.0.0");
            options.addArguments("--remote-debugging-port=9225");
//            options.addArguments("--remote-debugging-pipe");
            options.addArguments("--user-data-dir=C:\\cdp_user_data\\2");
            options.addArguments("--rbi-server-mode");
            //配置参数
            options.setExperimentalOption("excludeSwitches", new String[]{"--flag-switches-begin","enable-automation","--allow-pre-commit-input",
                    "--disable-background-networking","--disable-backgrounding-occluded-windows","--disable-client-side-phishing-detection",
            "--disable-default-apps","--disable-hang-monitor","--disable-popup-blocking","--disable-prompt-on-repost","--disable-sync",
            "--enable-blink-features","--enable-logging","--log-level","--no-first-run","--no-service-autorun","--password-store",
                    "--test-type","--use-mock-keychain","--flag-switches-end"});

            options.setBinary(new File("C:\\11\\mini_installer\\chrome\\Chrome-bin\\metaspace.exe"));

            WebDriver webDriver = new ChromeDriver(options);

            // 启动需要打开的网页
            System.out.println("--====--打完收工，正常");
        }catch (Exception e){
            System.out.println("-----还是异常");
        }
    }

}
