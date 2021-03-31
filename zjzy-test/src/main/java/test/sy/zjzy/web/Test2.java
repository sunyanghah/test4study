package test.sy.zjzy.web;

import java.util.ArrayList;

/**
 * Created by dell on 2019/9/5.
 */
public class Test2 {

    public static void main(String[] args) {
//        int i = 5;
//        // 1,1,1,1,1
//        // 1,2,1,1,
//        // 1,2,2
//        // 1,1,2,1
//        // 1,1,1,2
//        // 2,1,1,1
//        // 2,2,1
//        // 2,1,2
//
//        f10= f9+f8 = 89
//        f9 = f8+f7 = 55;
//        f8 = f7+f6 = 34;
//        f7 = f6+f5 = 21;
//        f6 = f5+f4 = 13;
//        f5 = f4+f3 = 8;
//        f4 = f3+f2 = 5;
//        f3 = f2+f1 = 3;
//        f2 = 2;
//        f1 = 1;
//
//        f5 = f3+f2+f3;
//        f5 = f2+f1+f2+f2+f1;
//        f5 = 2+1+2+2+1 = 8;
//
//
//        // 2,1,1
//        // 2,2
//        // 1,2,1
//        // 1,1,2
//        // 1,1,1,1
//        ----------
//        // 1,1,1
//        // 1,2
//        // 2,1
//        f3 = f2+f1;
//        f2 = 2 ,f1 = 1 f3 = 2+1

//        System.out.println(test1(10));

        StringBuilder sb = new StringBuilder();
        test3(0,sb);
        System.out.println(sb.toString());
    }

    private static int test1(int f){
        if (f == 1){
            return 1;
        }else if (f == 2){
          return 2;
        }else{
            return test1(f-1)+test1(f-2);
        }
    }
//
//    0 0 0
//    0 0 1
//    0 0 2
//    0 1 0
//    0 1 1
//    0 1 2
//    0 2 0
//    0 2 1
//    0 2 2
//    1 0 0
//    1 0 1
//    1 1 0
//    1 1 1

    private static void test3(int j,StringBuilder sb){
        for (int i = 0;i<3;i++){
            if (j == 2){
                String str = sb.toString();
                for (int k =0;k<3;k++){
                    System.out.println(str+k);
                }
                sb = new StringBuilder();
                j = 0;
            }else {
                sb.append(i);
                j++;
                test3(j, sb);
            }

        }
    }

    private static void test2(int f){
        ArrayList<String> result = new ArrayList<>();
        int[] m = new int[f];
        for (int i = 0;i<m.length;i++){
            for (int k=0;k<=2;k++){
                m[i] = k;

            }
        }

        for (int i = f-1;i>=0;i++){
            for (int k=0;k<=2;k++){
                m[i] = k;
                int sum = 0;
                for (int v : m){
                    sum += v;
                }
                if (sum == 10){
                    StringBuilder sb = new StringBuilder();
                    for (int v : m){
                        if (v != 0){
                            sb.append(v);
                        }
                    }
                    result.add(sb.toString());
                }
            }


            for (int j = 0;j<f-i;j++){
                System.out.println(j);
            }
        }
    }
}
