package test.study.java.mianshi2020;

/**
 * Created by dell on 2020/7/14.
 */
public class Test0714_3 {

    public static void main(String[] args) {

        Student student1 = new Student();
        Student student2 = new Student();

        System.out.println(student1.equals(student2));

        Long a = 1324234L;
        Long b = 1324234L;
        System.out.println(a.equals(b));
    }

    static class Student{

    }

}
