package test.sy.zjzy.web;

import com.carrotsearch.sizeof.RamUsageEstimator;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;

/**
 * Created by dell on 2019/9/3.
 */
public class Test1 {

    public static void main(String[] args) throws Exception{
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        StringBuilder sb = new StringBuilder();
        System.out.println("byte:"+RamUsageEstimator.sizeOf(byteArrayOutputStream));
        System.out.println("sb:"+RamUsageEstimator.sizeOf(sb));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream));
        for (int i = 0; i< 10000;i++){
            String s = String.valueOf(i);
            bw.write(s);
            sb.append(s);
        }
        bw.flush();
        System.out.println("byte:"+RamUsageEstimator.sizeOf(byteArrayOutputStream));
        System.out.println("sb:"+RamUsageEstimator.sizeOf(sb));
        for (int i = 0; i< 2000000;i++){
            String s = String.valueOf(i);
            bw.write(s);
            sb.append(s);
        }
        bw.flush();
        System.out.println("byte:"+RamUsageEstimator.sizeOf(byteArrayOutputStream));
        System.out.println("sb:"+RamUsageEstimator.sizeOf(sb));
    }
}
