package com.leetcode.dynamic;

import java.util.Arrays;

/**
 *  * 实例LeetCode474
 *  * 474. 一和零
 *  * @version 1.0
 *  https://leetcode-cn.com/problems/ones-and-zeroes/
 *  dp[i][x][y]表示 前 i 个元素 x 个 0，y 个 1 的最大子集数
 *    dp[i][x][y] = max(dp[i - 1][x - num[0]][y - num[1]] + 1, dp[i - 1][x][y])
 *    => dp[x][y] = max(dp[x - num[0]][y - num[1]] + 1, dp[x][y])
 */
public class LeetCode474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (String str : strs) {
            int num0 = 0, num1 = 0;
            for (int i = 0; i < str.length(); ++i) {
                if (str.charAt(i) == '0') {
                    num0++;
                } else {
                    num1++;
                }
            }
            //没给字符串只能拿一次，因此倒序处理
            for (int x = m; x >= num0; --x) {
                for (int y = n; y >= num1; --y) {
                    dp[x][y] = Math.max(dp[x - num0][y - num1] + 1, dp[x][y]);
                }
            }
        }
        return dp[m][n];
    }
}
