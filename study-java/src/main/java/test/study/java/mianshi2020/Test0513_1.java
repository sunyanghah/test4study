package test.study.java.mianshi2020;

/**
 * Created by dell on 2020/5/13.
 * @author dell
 */
public class Test0513_1 {

    public static void main(String[] args) {
        char[] aI = "123456789".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        int aiIndex = 0;
        int acIndex = 0;
        while(aiIndex < aI.length || acIndex < aC.length){
            if (aiIndex < aI.length){
                System.out.print(aI[aiIndex]);
                aiIndex++;
            }
            if (acIndex < aC.length) {
                System.out.print(aC[acIndex]);
                acIndex++;
            }
        }
    }

}
