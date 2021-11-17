package test.study.algorithm;

public class Recursion20211008 {

    /**
     * 求 x 的 n 次方
     * @author sunYang
     * @param args
     * @return void
     * @date 2021/10/8 15:27
     */
    public static void main(String[] args) {
        int x = 2;
        int n = 5;
        System.out.println(test1(x,n));
        System.out.println("---------------------------");
        System.out.println(test2(x,n));
    }

    // 循环 时间复杂度O(n)
    private static long test1(int x,int n){

        long result = 1;

        for (int i =0;i<n;i++){
            result = result*x;
        }

        return result;

    }


    // 递归 时间复杂度O(logn)
    private static long test2(int x, int n) {
        if (n == 0) {
            return 1;
        }
        long t = test2(x, n/2);
        if (n % 2 == 1) {
            return t*t*x; // 结果乘以结果
        }
        return t*t; // 结果乘以结果
    }

}
