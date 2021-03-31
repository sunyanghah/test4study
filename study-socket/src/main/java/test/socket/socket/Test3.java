package test.socket.socket;

import javax.websocket.*;
import java.net.URI;

/**
 * Created by dell on 2020/8/3.
 * @author dell
 */
public class Test3 {

    public static void main(String[] args) throws Exception{
        String url = "ws://localhost:8006/test2";
        Session session = ContainerProvider.getWebSocketContainer().connectToServer(MyClient.class, new URI(url));
        session.getBasicRemote().sendText("dd");
        session.close();
    }


}
