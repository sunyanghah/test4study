package test.socket2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * @author sunYang
 * @date 2022/9/8 15:06
 */
@Component
public class MyHandler extends TextWebSocketHandler {

    @Autowired
    WebSocketService service;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // 连接建立之后
        super.afterConnectionEstablished(session);
        service.addWebSocketSession(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        // 连接关闭之后
        super.afterConnectionClosed(session, status);
        service.removeWebSocketSession(session);
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        service.handleTextMessage(session, message);
    }

}
