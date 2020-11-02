package com.leetcode.dynamic;

/**
 *  * 实例LeetCode64
 *  * https://leetcode-cn.com/problems/minimum-path-sum/
 *  * @version 1.0
 *  最小路径和
 *  给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *      说明：每次只能向下或者向右移动一步
 *
 *  输入:
 *      [
 *          [1,3,1],
 *          [1,5,1],
 *          [4,2,1]
 *      ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小
 *
 * dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
 *      注意数组越界问题
 */
public class LeetCode64 {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int columns = grid[0].length;
        int[][] dp = new int[row][columns];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < columns; ++j) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                }
                else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        return dp[row - 1][columns - 1];
    }

    public int minPathSum2(int[][] grid) {
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int tp = Integer.MAX_VALUE;
                if (i > 0) {
                    tp = Math.min(tp, grid[i - 1][j]);
                }
                if (j > 0) {
                    tp = Math.min(tp, grid[i][j - 1]);
                }
                grid[i][j] += tp;
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
