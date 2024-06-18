package study.cdp.web;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.cdp.config.RbiConfigProperties;

import javax.annotation.Resource;
import java.io.File;
import java.util.Map;

/**
 * @author sun yang
 * @date 2024/3/11
 */
@RestController
@RequestMapping("/agent3")
public class AgentController3 {

    @Resource
    private RbiConfigProperties rbiConfigProperties;

    private ChromeDriver webDriver;

    private ChromeDriverService chromeDriverService;

    @GetMapping
    public OutAgentDto queryAgent(InAgentDto inAgentDto){

        OutAgentDto outDto = new OutAgentDto();

        RenderServerStatusEnum renderStatus = checkRender();
        if (RenderServerStatusEnum.NOT_STARTED.equals(renderStatus)){
            startRender(inAgentDto.getUserId());
        }else if (RenderServerStatusEnum.RUNNING.equals(renderStatus)){
            checkUser(inAgentDto.getUserId());

        }else if (RenderServerStatusEnum.QUIT.equals(renderStatus)){
            startRender(inAgentDto.getUserId());
        }

        String port = getPort();
        if (port != null) {
            outDto.setPort(Integer.parseInt(port));
        }

        return outDto;

    }

    private void startRender(Long userId){

        String userPath = "";
        if (userId != null){
            userPath = userId.toString();
        }

        // 谷歌驱动
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--remote-debugging-address=0.0.0.0");
        options.addArguments("--remote-debugging-port=0");
        options.addArguments("--remote-debugging-pipe");
        options.addArguments("--headless");

        options.addArguments("--user-data-dir="+rbiConfigProperties.getUserDataDir()+ File.separator+userPath);

        ChromeDriverService.Builder builder = new ChromeDriverService.Builder();
//        builder.usingDriverExecutable(new File("D:\\JAVA\\JDK1.8\\bin\\chromedriver.exe"));
        chromeDriverService = builder.build();

        webDriver = new ChromeDriver(chromeDriverService,options);

    }


    private void checkUser(Long userId){
        // running时检查入参用户是否是当前用户，避免两个正在使用的人冲突。那用户怎么释放？quit即释放？监控quit？
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

    public RenderServerStatusEnum checkRender(){
        if (webDriver == null){
            System.out.println("程序还没启动。。。");
            return RenderServerStatusEnum.NOT_STARTED;
        }

        if (chromeDriverService.isRunning()){
            System.out.println("程序没有退。。。。。。");
            return RenderServerStatusEnum.RUNNING;
        }else{
            System.out.println("程序退出了。。。。。。。。。。");
            return RenderServerStatusEnum.QUIT;
        }

    }

}
