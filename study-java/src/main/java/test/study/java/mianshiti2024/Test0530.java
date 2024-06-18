package test.study.java.mianshiti2024;

/**
 * @author sun yang
 * @date 2024/5/30
 */
public class Test0530 {

    public static void main(String[] args) {
        Test0530 test0530 = new Test0530();

        while (true){
            try {
                test0530.lease();
                break;
            }catch (Exception e){
            }
        }

    }

    private void lease(){
        System.out.println(1/0);
    }

}
