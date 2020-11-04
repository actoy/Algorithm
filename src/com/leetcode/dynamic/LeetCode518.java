package com.leetcode.dynamic;

import java.util.Arrays;

/**
 *  * 实例LeetCode518
 *  * 518. 零钱兑换 II
 *  * @version 1.0
 *  https://leetcode-cn.com/problems/coin-change-2/
 *  给定不同面额的硬币和一个总金额。
 *  写出函数来计算可以凑成总金额的硬币组合数。
 *  假设每一种面额的硬币有无限个。
 *
 *  输入: amount = 5, coins = [1, 2, 5]
 *  输出: 4
 *      解释: 有四种方式可以凑成总金额:
 *      5=5
 *      5=2+2+1
 *      5=2+1+1+1
 *      5=1+1+1+1+1
 *
 *  dp[i][j] 前i个硬币，凑成总金额为j的最大组合数
 *  dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]]
 *  => dp[j] = dp[j] + dp[j - coins[i]]   dp[0] = 1 -> 一个都不取
 *
 */
public class LeetCode518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j <= amount; ++j) {
                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }
}
