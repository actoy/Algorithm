package com.leetcode.dynamic;

/**
 *  * 实例LeetCode152
 *  * https://leetcode-cn.com/problems/maximum-product-subarray/
 *  * @version 1.0
 *  乘积最大子数组
 *  给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积
 *      输入: [2,3,-2,4]
 *      输出: 6
 *      解释: 子数组 [2,3] 有最大乘积 6
 *
 *      按照当前nums[i] 的正负来考虑结果
 *      nums[i] > 0
 *          maxDp[i] = max(nums[i], maxDp[i - 1] * nums[i]);
 *      nums <= 0
 *          minDp[i] = max(nums[i], minDp * nums[i]);
 *
 *          因此DP转移方程：
 *              if(nums[i] > 0) {
 *                  maxDp[i] = max(nums[i], maxDp[i - 1] * nums[i]);
 *                  minDp[i] = min(nums[i], minDp[i - 1] * nums[i]);
 *              }
 *              else {
 *                  maxDp[i] = max(nums[i], minDp[i - 1] * nums[i]);
 *                  minDp[i] = min(nums[i], maxDp[i - 1] * nums[i]);
 *              }
 */
public class LeetCode152 {
    public int maxProduct(int[] nums) {
        int ans = nums[0];
        int[] maxDp = new int[nums.length];
        int[] minDp = new int[nums.length];
        maxDp[0] = nums[0];
        minDp[0] = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > 0) {
                maxDp[i] = Math.max(nums[i], maxDp[i - 1] * nums[i]);
                minDp[i] = Math.min(nums[i], minDp[i - 1] * nums[i]);
            } else if (nums[i] <= 0) {
                maxDp[i] = Math.max(nums[i], minDp[i - 1] * nums[i]);
                minDp[i] = Math.min(nums[i], maxDp[i - 1] * nums[i]);
            }
            ans = Math.max(ans, maxDp[i]);
        }
        return ans;
    }
}
