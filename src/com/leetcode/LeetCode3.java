package com.leetcode;

import java.util.HashMap;

/**
 *  * 实例LeetCode3
 *  * 无重复字符的最长子串
 *  * @version 1.0
 *  
 */
public class LeetCode3 {
    public static void main(String[] arags) {
        String s = "dvdf";
        System.out.println( lengthOfLongestSubstring(s) );
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> pinyin = new HashMap <>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (pinyin.containsKey(s.charAt(i))) {
                left = Math.max(left, pinyin.get(s.charAt(i)) + 1);
            }
            pinyin.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

}
