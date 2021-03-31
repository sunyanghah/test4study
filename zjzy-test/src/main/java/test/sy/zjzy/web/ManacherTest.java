package test.sy.zjzy.web;

/**
 * Created by dell on 2019/9/9.
 * @author dell
 */
public class ManacherTest {


    public static void main(String[] args) throws Exception{
        String str = preData("aaaaaaaa");
        manacher(str);
    }

    private static String preData(String str) throws Exception{
        int length = str.length();
        StringBuilder sb = new StringBuilder("#");
        for (int i = 0;i < length;i++){
            sb.append(str.charAt(i)).append("#");
        }
        return sb.toString();
    }

    private static void manacher(String str) throws Exception{
        int length = str.length();
        int rightSide = 0;
        int rightCenter = 0;
        int[] halfSideArr = new int[length];
        int longestHalf = 0;
        int longestCenter = 0;
        for (int i =0;i<length;i++){
            boolean hasKz = true;
            if (i < rightSide){
                int left = 2*rightCenter-i;
                halfSideArr[i] = halfSideArr[left];
                if (halfSideArr[i] + i > rightSide){
                    halfSideArr[i] = rightSide - i;
                }
                if (halfSideArr[i] + i < rightSide){
                    hasKz = false;
                }
            }

            if (hasKz){
                while (i-1-halfSideArr[i] >=0 && i+1+halfSideArr[i] < length){
                    if (str.charAt(i-1-halfSideArr[i]) == str.charAt(i+1+halfSideArr[i])){
                        halfSideArr[i]++;
                    }else{
                        break;
                    }
                }
                if (halfSideArr[i] > longestHalf){
                    longestHalf = halfSideArr[i];
                    longestCenter = i;
                }
                rightSide = i + halfSideArr[i];
                rightCenter = i;
            }
        }
        StringBuilder rt = new StringBuilder();
        for (int i = longestCenter-longestHalf+1;i<=longestCenter+longestHalf;i+=2){
            rt.append(str.charAt(i));
        }
        System.out.println(rt);
    }

}
