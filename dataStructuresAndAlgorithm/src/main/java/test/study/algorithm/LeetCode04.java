package test.study.algorithm;

/**
 *
 * 二维数组中的查找
 *
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 *  
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 *
 * @author sunYang
 * @Date 2021-03-23
 */
public class LeetCode04 {

    public static void main(String[] args) {
        int[][] ints = new int[][]{new int[]{1,4,7,11,15},new int[]{2,5,8,12,19},new int[]{3,6,9,16,22},new int[]{10,13,14,17,24},new int[]{18,21,23,26,30}};
        System.out.println(test1(ints,24));
    }

    private static boolean test1(int[][] matrix,int target){
        int i = matrix.length-1;
        int j = 0;
        while (i >= 0 && j < matrix[0].length){
            if (matrix[i][j] > target){
                i--;
            }else if (matrix[i][j] < target){
                j++;
            }else {
                return true;
            }
        }
        return false;
    }

}
