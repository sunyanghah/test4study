package test.study.java.mianshi2020;

/**
 * Created by dell on 2020/7/6.
 * @author dell
 */
public class Test0706 {


    public static void main(String[] args) {
        int kThOdd = findKth(new int[]{5,2,4,1,3,7,6,-1,-3},3);
        System.out.println(kThOdd);
    }

    public static int findKth(int[] arr,int k){
        int length = arr.length;
        int[] oddArr = new int[length];
        int lastOddIndex = 0;
        for (int i : arr) {
            if (i%2 != 0){
                oddArr[lastOddIndex] = i;
                oddSort(oddArr,lastOddIndex);
                lastOddIndex++;
            }
        }
        if (k > lastOddIndex){
            return 0;
        }
        return oddArr[k-1];
    }

    public static void oddSort(int[] oddArr,int lastOddIndex){
        for (int i = lastOddIndex;i>0;i--){
            if (oddArr[i]<oddArr[i-1]){
                int temp = oddArr[i - 1];
                oddArr[i - 1] = oddArr[i];
                oddArr[i] = temp;
            }else{
                break;
            }
        }
    }


}
