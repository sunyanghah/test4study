package test.study.java.mianshiti2021;

public class Test0810 {

    public static void main(String[] args) {
        int[] arr = new int[]{7,5,6,1};
        System.out.println(findSecond2(arr));
    }

    public static int findSecond2(int[] arr){
        int max = 0;
        int second  = 0;
        for (int num : arr) {
            if (num > max){
                second = max;
                max = num;
            }else if(num > second){
                second = num;
            }
        }
        return second;
    }

}
