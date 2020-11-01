package com;

import com.leetcode.LeetCode1143;

/**
 *  * 实例MyTest
 *  *
 *  * @version 1.0
 *  
 */
public class MyTest {
    public static void main(String[] args) {
        LeetCode1143 leetCode = new LeetCode1143();
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(leetCode.longestCommonSubsequence(text1, text2));
    }
}
