package com.leetcode;

import java.util.Arrays;

/**
 *  * 实例LeetCode300
 *  * 最长上升子序列
 *  * @version 1.0
 *  https://leetcode-cn.com/problems/longest-increasing-subsequence/
 *  给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *      输入: [10,9,2,5,3,7,101,18]
 *      输出: 4
 *      解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 *      注意：{} {0} 等特殊情况
 *
 *      dp[i] 表示前i个数，以第i个数为结尾的最长上升子序列的最大长度，估转移方程如下:
 *      dp[i] = max(1, dp[j] + 1), a[j] < a[i], j < i
 */
public class LeetCode300 {

    public int lengthOfLIS(int[] nums) {
        int ans = 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            int tmp = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    tmp = Math.max(tmp, dp[j] + 1);
                }
            }
            dp[i] = tmp;
            ans = Math.max(ans, tmp);
        }
        return ans;
    }

    /**
     * dp[i]: 所有长度为i+1的递增子序列中, 最小的那个序列尾数. 如 i = 2，及 [2,3,7,101] 中的3
     *      => 相当于维护一个结果数组，如果当前元素比结果数组的值都大的的话，就追加在结果数组后面（相当于递增序列长度加了1）；否则的话用当前元素覆盖掉第一个比它大的元素
     * 由定义可知，dp是一个递增数组，可以用maxL来表示最长的递增子序列长度
     * 依次遍历数组，将num插入到dp中恰当的位置
     * 1, i == maxL, num > dp[i] num比当前数组中所有数都大，则将num加入dp中的尾部，maxL++
     * 2, dp[i - 1] < maxL <= dp[i] 只更新dp[i] 即可
     */
    public int lengthOfLIS1(int[] nums) {
        int maxL = 0;
        int[] dp = new int[nums.length];
        for (int num : nums) {
            int left = 0, right = maxL;
            while (left < right) {
                int mid = left + ((right - left) >> 1);
                if (dp[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            dp[left] = num;
            if (left == maxL) {
                maxL++;
            }
        }
        return maxL;
    }

    /**
     * 使用Arrays.binarySearch
     */
    public int lengthOfLIS2(int[] nums) {
        int[] dp = new int[nums.length];
        int maxL = 0;
        for (int num : nums) {
            int index = Arrays.binarySearch(dp, 0, maxL, num);
            index = index < 0 ? - (index + 1) : index;
            dp[index] = num;
            if (index == maxL) {
                maxL++;
            }
        }
        return maxL;
    }
}