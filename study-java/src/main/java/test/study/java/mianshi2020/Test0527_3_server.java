package test.study.java.mianshi2020;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by dell on 2020/5/27.
 * @author dell
 *
 * 阻塞 server
 *
 */
public class Test0527_3_server {

    public static void main(String[] args) throws Exception{

        // 1. 获取通道
        ServerSocketChannel server = ServerSocketChannel.open();

        // 2. 得到文件通道，将客户端传递过来的图片写出到本地目录
        FileChannel outChannel = FileChannel.open(Paths.get("f:/图/copy/0527block.jpg"), StandardOpenOption.WRITE,StandardOpenOption.CREATE);

        // 3. 绑定端口
        server.bind(new InetSocketAddress(6666));

        // 4. 获取客户端的连接（阻塞）
        SocketChannel client = server.accept();

        // 5. 要使用NIO，有了Channel,就必须要有Buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // 6. 将客户端传递过来的图片保存
        while(client.read(buffer) != -1){
            // 在读之前要切换成读模式
            buffer.flip();

            outChannel.write(buffer);
            // 读完切换成写模式，能让管道继续读取文件的数据
            buffer.clear();
        }

        // 7. 关闭通道
        outChannel.close();

        client.close();

        server.close();


    }

}
