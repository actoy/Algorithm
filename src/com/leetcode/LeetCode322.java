package com.leetcode;

/**
 *  * 实例LeetCode322
 *  * 链接：https://leetcode-cn.com/problems/coin-change
 *  * @version 1.0
 *  给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 *      如果没有任何一种硬币组合能组成总金额，返回 -1。
 *  你可以认为每种硬币的数量是无限的。
 *  eg：
 *      输入：coins = [1, 2, 5], amount = 11
 *      输出：3
 *      解释：11 = 5 + 5 + 1
 *
 *  dp[j] = min(dp[j], dp[j - x] + 1) 当前硬币面额 x   ans = min(dp[amount])
 */
public class LeetCode322 {
    public int coinChange(int[] coins, int amount) {
        int ans = Integer.MAX_VALUE;
        int[] dp = new int[amount + 1];
        //初始化
        dp[0] = 0;
        for (int j = 1; j <= amount; ++j) {
            dp[j] = amount + 1;
        }
        for (int i = 0; i < coins.length; ++i) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
            ans = Math.min(ans, dp[amount]);
        }
        return ans == amount + 1 ? -1 : ans;
    }
}
