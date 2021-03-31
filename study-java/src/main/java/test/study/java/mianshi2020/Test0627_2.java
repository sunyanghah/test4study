package test.study.java.mianshi2020;

import com.carrotsearch.sizeof.RamUsageEstimator;
import org.openjdk.jol.info.ClassLayout;

/**
 * Created by dell on 2020/6/27.
 * @author dell
 */
public class Test0627_2 {

    public static void main(String[] args) {
        String str = "a";
        System.out.println(RamUsageEstimator.sizeOf(str));
        System.out.println(RamUsageEstimator.sizeOf(new Object()));
        System.out.println(RamUsageEstimator.sizeOf(1234234232));
        System.out.println(RamUsageEstimator.sizeOf('a'));
        System.out.println("-------------------");
        System.out.println(ClassLayout.parseInstance(str).toPrintable());
    }

}
