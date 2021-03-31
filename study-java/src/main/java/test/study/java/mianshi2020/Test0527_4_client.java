package test.study.java.mianshi2020;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by dell on 2020/5/27.
 * @author dell
 *
 * 阻塞  client
 */
public class Test0527_4_client {

    public static void main(String[] args)  throws Exception{
        // 1. 获取通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",6666));

        // 2. 放松一张图片给服务端
        FileChannel fileChannel = FileChannel.open(Paths.get("f:/图/rickandmorty.jpg"), StandardOpenOption.READ);

        // 3. 要使用NIO，有了Channel，就必然要有buffer.
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // 4. 读取本地文件，发送到服务器
        while (fileChannel.read(buffer) != -1){
            // 在读之前要切换成读模式
            buffer.flip();

            socketChannel.write(buffer);

            // 读完切换成写模式，能让管道继续读取文件的数据
            buffer.clear();
        }

        socketChannel.shutdownOutput();

        int len;
        while ((len = socketChannel.read(buffer)) != -1){
            buffer.flip();

            System.out.println(new String(buffer.array(),0,len));

            buffer.clear();
        }

        // 5. 关闭流
        fileChannel.close();
        socketChannel.close();

    }

}
