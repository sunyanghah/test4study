package test.study.algorithm;

import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * 两数之和
 *
 *
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 你可以按任意顺序返回答案
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 *
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 *
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 * @author sunYang
 * @Date 2021-03-20
 */
public class LeetCode01 {

    public static void main(String[] args) {
//        int[] nums = {2, 7, 11, 15};
//        int target = 9;
        int[] nums = {3, 2, 4};
        int target = 6;

//        int[] nums = {3, 3};
//        int target = 6;


        int[] result = twoSum(nums, target);
        Arrays.stream(result).forEach(System.out::print);
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> valIndMap = new HashMap<>();
        for (int i =0;i<nums.length;i++){
            if (valIndMap.containsKey(target - nums[i])){
                return new int[]{valIndMap.get(target - nums[i]),i};
            }
            valIndMap.put(nums[i],i);
        }
        return new int[0];
    }


}
