package test.socket.socket;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by dell on 2020/7/23.
 * @author dell
 */
public class TestSocket {

    public static void main(String[] args) throws Exception{
        String url = "120.79.22.106/cpu/webSocketServer?token=XXX&uuid=XXX&types=XXX&socketType=XXX&tagIds=XXX&mapIds=XXX&projectIds=XXX&token=XXX";
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("120.79.22.106",80));
        ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
        writeBuffer.put("testContect".getBytes());
        writeBuffer.flip();
        socketChannel.write(writeBuffer);
        writeBuffer.clear();

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int len;
        while ((len = socketChannel.read(buffer)) != -1){
            buffer.flip();

            System.out.println(new String(buffer.array(),0,len));

            buffer.clear();
        }
    }

}
