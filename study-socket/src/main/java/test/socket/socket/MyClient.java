package test.socket.socket;

import javax.websocket.*;

/**
 * Created by dell on 2020/8/3.
 * @author dell
 */
@ClientEndpoint
public class MyClient{
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("client open");
    }
    @OnMessage
    public void onMessage(String message) {
        System.out.println("Client onMessage: " + message);
    }
    @OnClose
    public void onClose() {
        System.out.println("client close");
    }
}
