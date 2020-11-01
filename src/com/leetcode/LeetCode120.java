package com.leetcode;

import java.util.List;

/**
 * leetcode 120. 三角形最小路径和
 * https://leetcode-cn.com/problems/triangle/
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点
 * dp[i][j] 表示到了第i行，第j列位置，最小路径和
 * dp[i][j] = min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j)
 */
public class LeetCode120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int ans = Integer.MAX_VALUE;
        int n = triangle.size();
        int dp[][] = new int[n][triangle.get(n - 1).size()];

        for (int i = 0; i < n; ++i) {
            for (int j = 0 ; j < triangle.get(i).size(); ++j) {
                if (i == 0) {
                    dp[i][j] = triangle.get(i).get(j);
                } else if (j == 0) {
                    dp[i][j] = triangle.get(i).get(j) + dp[i - 1][j];
                } else if (j == triangle.get(i).size() - 1) {
                    dp[i][j] = triangle.get(i).get(j) +dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
                }
                if (i == n - 1) {
                    ans = Math.min(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }
}
