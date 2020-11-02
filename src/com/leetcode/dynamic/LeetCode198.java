package com.leetcode.dynamic;

/**
 *  * 实例LeetCode198
 *  * 198. 打家劫舍
 *  * @version 1.0
 *  https://leetcode-cn.com/problems/house-robber/
 *
 *  你是一个专业的小偷，计划偷窃沿街的房屋。
 *  每间房内都藏有一定的现金，
 *  影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 *  如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 *  给定一个代表每个房屋存放金额的非负整数数组，
 *  计算你 不触动警报装置的情况下 ，
 *  一夜之内能够偷窃到的最高金额
 *
 * eg1：
 *  输入：[1,2,3,1]
 *  输出：4
 *  解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4
 *
 *  输入：[2,7,9,3,1]
 *  输出：12
 *  解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12
 *
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 *
 *  dp[i] 表示偷窃第i个房屋时，最高的金额
 *  dp[i] = max(dp[j] + nums[i], nums[i]) i - j > 1
 */
public class LeetCode198 {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        int ans = 0;
        for (int i = 0; i < nums.length; ++i) {
            dp[i] = nums[i];
            for (int j = 0; j < i - 1; ++j) {
                dp[i] = Math.max(dp[j] + nums[i], dp[i]);
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
