package com;

import com.leetcode.dynamic.LeetCode1143;
import com.leetcode.dynamic.LeetCode198;

/**
 *  * 实例MyTest
 *  *
 *  * @version 1.0
 *  
 */
public class MyTest {
    public static void main(String[] args) {
//        leetCode1143();

        leetCode198();
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
}
