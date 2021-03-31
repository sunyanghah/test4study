package test.socket.socket;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * Created by dell on 2020/7/23.
 * @author dell
 */
@ServerEndpoint("/test2")
@Component
public class Test2 {

    private Session session;

    private String ip; // 客户端ip

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("ip") String ip) {
        this.session = session;
        this.ip = ip;
		System.out.println("有新连接加入！");

    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(@PathParam("ip") String ip) {
         System.out.println("有一连接关闭");
    }


    /**
     * 发生错误时调用
     */
    @OnError
    public void onError(Session session, Throwable error) {
		System.out.println("发生错误");
        error.printStackTrace();

    }

    @OnMessage
    public void test2(String message){
        System.out.println(message);
        try {
            session.getBasicRemote().sendText("sdfasdfasffffffff");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
