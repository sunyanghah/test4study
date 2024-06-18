package study.cdp.config;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * @author sun yang
 * @date 2024/3/15
 */
public class RbiUtil {

    public static boolean isPortAvailable(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) { // 尝试在该端口号上创建一个ServerSocket
            return true; // 如果成功创建 ServerSocket，说明端口号可用
        } catch (IOException e) {
            return false; // 如果创建 ServerSocket 发生异常，则说明端口号不可用
        }
    }

}
