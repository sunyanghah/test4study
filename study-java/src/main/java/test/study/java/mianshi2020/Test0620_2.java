package test.study.java.mianshi2020;

/**
 * Created by dell on 2020/6/20.
 */
public class Test0620_2 {

    public static void main(String[] args) {
        Object object = new Object();
        try {
            object.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
