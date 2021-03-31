package test.study.java.mianshi2020;

/**
 * @author sunYang
 * @Date 2020/8/31
 */
public class Test0831 {

    public static void main(String[] args) {
        String idNumber = "311202190010104125";
        String telephone = "11020201010";
        System.out.println(idNumberSecret(idNumber));
        System.out.println(telephoneSecret(telephone));
    }

    private static String idNumberSecret(String idNumber){
        return idNumber.substring(0,idNumber.length()-4)+"****";
    }

    private static String telephoneSecret(String telephone){
        return telephone.substring(0,3)+"****"+telephone.substring(7,telephone.length());
    }
}
