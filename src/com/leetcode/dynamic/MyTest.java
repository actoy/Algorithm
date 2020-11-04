package com.leetcode.dynamic;

import com.leetcode.dynamic.LeetCode1143;
import com.leetcode.dynamic.LeetCode198;
import com.leetcode.dynamic.LeetCode354;
import com.leetcode.dynamic.LeetCode72;

/**
 *  * 实例MyTest
 *  *
 *  * @version 1.0
 *  
 */
public class MyTest {
    public static void main(String[] args) {
//        leetCode1143();
//        leetCode198();
//        leetCode354();
//        leetCode72();
//        leetCode416();
//        leetCode494();
        leetCode474();
    }

    public static void leetCode1143() {
        LeetCode1143 leetCode = new LeetCode1143();
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(leetCode.longestCommonSubsequence(text1, text2));
    }

    public static void leetCode198() {
        LeetCode198 leetCode = new LeetCode198();
        int[] nums = {2,7,9,3,1};
//        int[] nums = {1,2,3,1};
        System.out.println(leetCode.rob(nums));
    }

    public static void leetCode354() {
        LeetCode354 leetCode = new LeetCode354();
        int[][] envelopes = {{4,5}, {4,6}, {6,7}, {2,3}, {1,1}};
        System.out.println(leetCode.maxEnvelopes(envelopes));
    }

    public static void leetCode72() {
        LeetCode72 leetCode = new LeetCode72();
//        String word1 = "horse";
//        String word2 = "ros";
        String word1 = "intention";
        String word2 = "execution";
        System.out.println(leetCode.minDistance(word1, word2));
    }

    public static void leetCode416() {
        LeetCode416 leetCode416 = new LeetCode416();
        int[] nums = {1,2,5};
//        int[] nums = {1,5,11,5};
        System.out.println(leetCode416.canPartition(nums));
    }

    public static void leetCode494() {
        LeetCode494 leetCode494 = new LeetCode494();
        int[] nums = {1, 1, 1, 1, 1};
        int S = 3;
        System.out.println(leetCode494.findTargetSumWays(nums, S));
    }

    public static void leetCode474() {
        LeetCode474 leetCode474 = new LeetCode474();
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5;
        int n = 3;
        System.out.println(leetCode474.findMaxForm(strs, m, n));
    }
}
