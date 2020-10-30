package com.leetcode;

/**
 *  * 实例LeetCode0801
 *  * https://leetcode-cn.com/problems/three-steps-problem-lcci/
 *  * @version 1.0
 *  面试题 08.01. 三步问题
 *      三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。
 *      实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007
 *
 *      输入：n = 3
 *      输出：4
 *      说明：有四种走法
 *      dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3] 注意i的大小，避免数组越界
 */
public class LeetCode0801 {
    public int waysToStep(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; ++i) {
            dp[i] = dp[i - 1];
            if (i >= 2) {
                dp[i] = (dp[i] + dp[i - 2]) % 1000000007;
            }
            if (i >= 3) {
                dp[i] = (dp[i] + dp[i - 3]) % 1000000007;
            }
        }

        return dp[n] % 1000000007;
    }
}
