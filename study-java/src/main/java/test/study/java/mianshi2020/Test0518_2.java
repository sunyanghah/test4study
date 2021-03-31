package test.study.java.mianshi2020;

/**
 * Created by dell on 2020/5/18.
 * @author dell
 */
public class Test0518_2 {

    public static void main(String[] args) {
        int num = 0;
        for (int i =0;i<Integer.MAX_VALUE;i++){
            num += i;
        }
        // 1073741825
        System.out.println(num);
    }

}
