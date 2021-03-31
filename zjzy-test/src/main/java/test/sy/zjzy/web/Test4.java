package test.sy.zjzy.web;

/**
 * Created by dell on 2019/9/6.
 */
public class Test4 {

    public static void main(String[] args) {
        int n = 4;
        long max = 0;
        int[][] dp = new int[n][n];
        dp[0][0] = 5;
        dp[1][0] = 8;
        dp[1][1] = 4;
        dp[2][0] = 3;
        dp[2][1] = 6;
        dp[2][2] = 9;
        dp[3][0] = 7;
        dp[3][1] = 2;
        dp[3][2] = 9;
        dp[3][3] = 5;

        int[][] dpSum = new int[n][n];

        for(int i=0;i<n;i++){
             for(int j=0;j<=i;j++){
                 int num  = dp[i][j];
                 if (i == 0){
                     dpSum[i][j] = dp[i][j];
                     System.out.print(dpSum[i][j]+"---");
                 }else if(j==0){
                     dpSum[i][j] = dpSum[i-1][j] + num;
                 }else {
                     int max1 = Math.max(dpSum[i - 1][j - 1], dpSum[i - 1][j]);
                     dpSum[i][j] = max1+num;
                     System.out.print(max1+"---");
                 }
                 max = Math.max(dpSum[i][j],max);
             }
         }
         System.out.println(max);
     }
}
