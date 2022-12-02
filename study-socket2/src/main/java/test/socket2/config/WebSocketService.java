package test.socket2.config;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sunYang
 * @date 2022/9/8 15:07
 */
@Service
public class WebSocketService {
    // 用synchronized或ConcurrentHashMap保证多线程安全，因为我们还需要实现广播，所以这里我用了synchronized实现线程安全
    Map<String, WebSocketSession> sessionMap = new HashMap<>();

    public synchronized void addWebSocketSession(WebSocketSession session) {
        String id = session.getId();// 从session中获取的唯一标识
        // session 中还可以获得其他握手前的http各种属性，如URL，请求头，这些也可以作为唯一标识
        sessionMap.put(id, session); //保存会话
    }

    public synchronized void removeWebSocketSession(WebSocketSession session) {
        String id = session.getId();
        sessionMap.remove(id); // 删除会话
    }
    public synchronized void broadcast(String message) {
        for(WebSocketSession session: sessionMap.values()) {
            TextMessage tm = new TextMessage(message);
            try {
                session.sendMessage(tm);
            } catch (IOException e) {
                // 发送失败后，需要继续给其他人广播，因此在循环里面用 try 捕获异常
            }
        }
    }
    public synchronized void unicast(String id, String message) {
        WebSocketSession session = sessionMap.get(id);
        TextMessage tm = new TextMessage(message);
        try {
            session.sendMessage(tm);
        } catch (IOException e) {
        }
    }

    public synchronized void handleTextMessage(WebSocketSession session, TextMessage message) {
        // 处理另一端发送过来的消息
    }
}
