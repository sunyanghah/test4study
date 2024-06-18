package test.study.java.mianshiti2024;

/**
 * 接雨水
 * @author sun yang
 * @date 2024/4/15
 */
public class Test0415 {

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(trap(height));

    }

    public static int trap(int[] height) {
        int length = height.length;
        int[] leftMax = new int[length];
        leftMax[0] = height[0];
        for (int i = 1; i < length; ++i)// 计算左边的最大值
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);

        int[] rightMax = new int[length];
        rightMax[length - 1] = height[length - 1];
        for (int i = length - 2; i >= 0; --i)// 计算右边的最大值
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);

        // 根据左右两边的最大值来确定当前柱子所能容纳的水量。
        int water = 0;
        for (int i = 0; i < length; ++i)
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        return water;
    }

}
