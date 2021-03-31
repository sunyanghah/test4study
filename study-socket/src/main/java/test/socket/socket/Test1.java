package test.socket.socket;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by dell on 2020/7/23.
 * @author dell
 */
public class Test1 {

    public static void main(String[] args) throws Exception{
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",8006));
        ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
        writeBuffer.put("test2".getBytes());
        writeBuffer.flip();
        socketChannel.write(writeBuffer);
        writeBuffer.clear();
    }

}
