package test.study.java.mianshi2020;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by dell on 2020/5/27.
 * @author dell
 *
 * FileChannel
 *
 * channel 比作铁路，buffer比作火车。相比于传统IO流是单向的来说，channel管道是双向的。
 *
 */
public class Test0527_2 {

    public static void main(String[] args) throws Exception{
        File source = new File("f:/图/rickandmorty.jpg");
        File target = new File("f:/图/copy/rickandmorty_copy.jpg");
        if (!source.exists()){
            throw new Exception("source 文件不存在");
        }
//        if (!target.exists()){
//            target.createNewFile();
//        }
        transferFileWithIO(source,target);
        File target2 = new File("f:/图/copy/rickandmorty_copy2.jpg");
        transferFileWithNIO(source,target2);
    }

    private static void transferFileWithIO(File source,File target) throws Exception{
        BufferedInputStream read = new BufferedInputStream(new FileInputStream(source));
        BufferedOutputStream write = new BufferedOutputStream(new FileOutputStream(target));
        byte[] bytes = new byte[1024];
        while(read.read(bytes) != -1){
            write.write(bytes);
        }
        write.flush();
        write.close();
        read.close();
    }

    private static void transferFileWithNIO(File source,File target) throws Exception{
        RandomAccessFile read = new RandomAccessFile(source,"rw");
        RandomAccessFile write = new RandomAccessFile(target,"rw");
        FileChannel readChannel = read.getChannel();
        FileChannel writeChannel = write.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (readChannel.read(byteBuffer) > 0){
            byteBuffer.flip();
            writeChannel.write(byteBuffer);
            byteBuffer.clear();
        }

        writeChannel.close();
        readChannel.close();
    }
}
