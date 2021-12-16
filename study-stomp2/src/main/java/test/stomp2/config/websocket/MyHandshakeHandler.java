package test.stomp2.config.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Map;

/**
 * @author sunYang
 * @date 2021/12/7 16:27
 */
@Component
@Slf4j
public class MyHandshakeHandler extends DefaultHandshakeHandler {

    @Override
    protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String, Object> attributes) {
        log.info("====================================================this=====");
        return super.determineUser(request, wsHandler, attributes);
    }

    private HttpSession getSession(ServerHttpRequest request) {
        ServletServerHttpRequest serverRequest = (ServletServerHttpRequest) request;
        return serverRequest.getServletRequest().getSession(true);
    }
}
