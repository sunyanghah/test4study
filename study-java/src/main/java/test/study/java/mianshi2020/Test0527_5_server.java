package test.study.java.mianshi2020;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;

/**
 * Created by dell on 2020/5/27.
 * @author dell
 *
 * 非阻塞 server
 *
 */
public class Test0527_5_server {

    public static void main(String[] args) throws Exception{

        // 1. 获取通道
        ServerSocketChannel server = ServerSocketChannel.open();

        // 2 切换成非阻塞模式
        server.configureBlocking(false);

        // 3. 绑定端口
        server.bind(new InetSocketAddress(6666));

        // 4. 获取选择器
        Selector selector = Selector.open();

        // 4.1 将通道注册到选择器上，指定接收“监听通道”事件
        server.register(selector, SelectionKey.OP_ACCEPT);

        // 5. 轮询的获取选择器上已就绪的事件
        while (selector.select() > 0){

            // 6. 获取当前选择器所有注册的“选择器”(已就绪的监听事件)
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

            // 7. 获取已“就绪”的事件，（不同的事件做不同的事）
            while (iterator.hasNext()){

                SelectionKey selectionKey = iterator.next();

                // 接收事件就绪
                if (selectionKey.isAcceptable()){

                    // 8. 获取客户端的连接
                    SocketChannel client = server.accept();

                    // 8.1 切换成非阻塞模式
                    client.configureBlocking(false);

                    // 8.2 注册到选择器上 --> 拿到客户端的连接为了读取通道的数据（监听读就绪事件）
                    client.register(selector,SelectionKey.OP_READ);

                } else if (selectionKey.isReadable()){

                    // 9. 获取当前选择器读就绪状态的通道
                    SocketChannel client = (SocketChannel) selectionKey.channel();

                    // 9.1 读取数据
                    ByteBuffer buffer = ByteBuffer.allocate(1024);

                    // 9.2 得到文件通道
                    FileChannel outChannel = FileChannel.open(Paths.get("f:/图/copy/0527_no_block.jpg"), StandardOpenOption.WRITE,StandardOpenOption.CREATE);

                    while (client.read(buffer) != -1){

                        buffer.flip();

                        outChannel.write(buffer);

                        buffer.clear();

                    }

                    outChannel.close();

//                    client.close();
                }

                // 10. 取消选择键(已经处理过的事件，就应该取消了)
                iterator.remove();
            }
        }

    }

}
