package com.leetcode.dynamic;

/**
 *  * 实例LeetCode416
 *  * 416. 分割等和子集
 *  * @version 1.0
 *  https://leetcode-cn.com/problems/partition-equal-subset-sum/
 *
 *  给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *  注意:
 *  每个数组中的元素不会超过 100
 *  数组的大小不会超过 200
 *  eg:
 *  输入: [1, 5, 11, 5]
 *  输出: true
 *  解释: 数组可以分割成 [1, 5, 5] 和 [11]
 *
 *  输入: [1, 2, 3, 5]
 *  输出: false
 *  解释: 数组不能分割成两个元素和相等的子集
 *
 *  dp[i][j] 表示从数组的 [0,i] 下标范围内选取若干个正整数（可以是 0 个），
 *      是否存在一种选取方案使得被选取的正整数的和等于 j
 *      初始时，dp 中的全部元素都是false
 *  如果j >= nums[i], 则对于当前的数字nums[i], 可以选取也可以不选取, 两种情况只要有一个为true，dp[i][j]=true
 *      如果不选取 nums[i]: dp[i][j] = dp[i - 1][j]
 *      如果选取  nums[i]: dp[i][j] = dp[i - 1][j - nums[i]]
 *  如果j < nums[i], 则在选取的数字的和等于 jj 的情况下无法选取当前的数字
 *      dp[i][j] = dp[i - 1][j]
 *
 *   dp[i][j] = dp[i - 1][j - nums[i]] | dp[i - 1][j]   j >= nums[i]
 *              dp[i - 1][j]                            j < nums[i]
 *   由上dp状态方程 得出每一行的 dp 值都只与上一行的 dp 值有关，因此可优化为：
 *    dp[j] = dp[j] | dp[j - nums[i]]
 */
public class LeetCode416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int value : nums) {
            sum += value;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int avg = sum >> 1;
        int[] dp = new int[avg + 1];
        dp[0] = 1;
        for (int i = 1; i <= nums.length; ++i) {
            for (int j = avg; j >= nums[i - 1]; --j) {
                if (dp[j - nums[i - 1]] == 1) {
                    dp[j] = 1;
                }
            }
        }
        return dp[avg] == 1;
    }
}