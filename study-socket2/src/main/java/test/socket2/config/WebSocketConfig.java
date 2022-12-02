package test.socket2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @author sunYang
 * @date 2022/9/8 15:05
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Autowired
    MyHandler myHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry
                .addHandler(myHandler, "/myHandler") // 指定处理的 websocket 路径 /myHandler
                //.addInterceptors()  添加你自己的拦截器
                //.addInterceptors(new HttpSessionHandshakeInterceptor())
                .setAllowedOrigins("*"); // 设置允许连接的源，正式上线话要做调整
    }
}
