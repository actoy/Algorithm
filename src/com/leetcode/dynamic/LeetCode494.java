package com.leetcode.dynamic;

import java.util.Arrays;

/**
 *  * 实例LeetCode494
 *  * 494. 目标和
 *  * @version 1.0
 *  https://leetcode-cn.com/problems/target-sum/
 *
 *  给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。
 *  现在你有两个符号 + 和 -。
 *  对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 *
 *  返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 *  eg:
 *  输入：nums: [1, 1, 1, 1, 1], S: 3
 *  输出：5
 *  解释：
 *
 *   -1+1+1+1+1 = 3
 *   +1-1+1+1+1 = 3
 *   +1+1-1+1+1 = 3
 *   +1+1+1-1+1 = 3
 *   +1+1+1+1-1 = 3
 *
 *   一共有5种方法让最终目标和为3
 *
 *  dp(i, j) 表示[0, i] 个数中和为 j 的最大组成方案
 *  对nums[i] 有两种情况
 *  j >= nums[i] 数字和为 j ，有以下两种组成方案
 *    取 dp[i - 1][j - nums[i]]
 *    不取 dp[i - 1][j]
 *  j < nums[i] 数字和为 j ，有以下一种组成方案
 *    dp[i][j] = d[i - 1][j]
 *
 *  因此dp方程为: dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]]
 *  => dp[j] += dp[j - nums[i]]  dp[0] = 1
 *
 */
public class LeetCode494 {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int target = sum - S;
        if (sum < S || target % 2 == 1) {
            return 0;
        }
        target /= 2;
        int[] dp = new int[target + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        for (int num : nums) {
            for (int j = target; j >= num; --j) {
                dp[j] += dp[j - num];
            }
        }
        return dp[target];
    }
}
