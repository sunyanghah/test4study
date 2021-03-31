package test.study.java.mianshi2020;

import java.nio.ByteBuffer;

/**
 * Created by dell on 2020/5/27.
 * @author dell
 *
 * ByteBuffer
 *
 */
public class Test0527_1 {

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        System.out.println("limit----"+byteBuffer.limit());
        System.out.println("position----"+byteBuffer.position());
        System.out.println("capacity----"+byteBuffer.capacity());
        System.out.println("mark----"+byteBuffer.mark());

        System.out.println("-----------------------------------------------");

        String s = "abcdefg";
        byteBuffer.put(s.getBytes());
        System.out.println("limit----"+byteBuffer.limit());
        System.out.println("position----"+byteBuffer.position());
        System.out.println("capacity----"+byteBuffer.capacity());
        System.out.println("mark----"+byteBuffer.mark());

        System.out.println("-----------------------------------------------");

        byteBuffer.flip();
        System.out.println("limit----"+byteBuffer.limit());
        System.out.println("position----"+byteBuffer.position());
        System.out.println("capacity----"+byteBuffer.capacity());
        System.out.println("mark----"+byteBuffer.mark());
        byte[] bytes = new byte[byteBuffer.limit()];
        byteBuffer.get(bytes);
        System.out.println("-------------");
        System.out.println(new String(bytes));
        System.out.println("-------------");
        System.out.println("limit----"+byteBuffer.limit());
        System.out.println("position----"+byteBuffer.position());
        System.out.println("capacity----"+byteBuffer.capacity());
        System.out.println("mark----"+byteBuffer.mark());

        System.out.println("-----------------------------------------------");

        byteBuffer.clear();
        System.out.println("limit----"+byteBuffer.limit());
        System.out.println("position----"+byteBuffer.position());
        System.out.println("capacity----"+byteBuffer.capacity());
        System.out.println("mark----"+byteBuffer.mark());
    }

}
