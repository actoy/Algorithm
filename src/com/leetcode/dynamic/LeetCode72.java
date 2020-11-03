package com.leetcode.dynamic;

import java.util.Arrays;

/**
 *  * 实例LeetCode72
 *  * 72. 编辑距离
 *  * @version 1.0
 *  https://leetcode-cn.com/problems/edit-distance/
 *  给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 *  你可以对一个单词进行如下三种操作：
 *      插入一个字符
 *      删除一个字符
 *      替换一个字符
 *
 *  输入：word1 = "horse", word2 = "ros"
 *  输出：3
 *  解释：
 *      horse -> rorse (将 'h' 替换为 'r')
 *      rorse -> rose (删除 'r')
 *      rose -> ros (删除 'e')
 *
 *  dp[i][j]的含义为：word1的前i个字符和word2的前j个字符的编辑距离。
 *      意思就是word1的前i个字符，变成word2的前j个字符，最少需要这么多步
 *      例如：word1 = "horse", word2 = "ros"，那么dp[3][2]=X就表示"hor"和“ro”的编辑距离，即把"hor"变成“ro”最少需要X步。
 *          如果下标为零则表示空串，比如：dp[0][2]就表示空串""和“ro”的编辑距离
 *
 *  word1="horse" word2="ros" 现在算这俩字符串的编辑距离，就是找从word1，最少多少步，能变成word2？那就有三种方式：
 *  1.hors 变成 ros 假设需要x步，那么从 horse 到 ros 就是 horse -> hors -> ros （先x步，再一次删除，总共x + 1步）即 dp[i - 1][j] + 1
 *  2.horse 变成 ro 假设需要y步，那么从 horse 到 ros 就是 horse -> ro -> ros (先y步，再一次添加，总共y + 1步）即 dp[i][j - 1] + 1
 *  3.hors 变成 ro 假设需要z步，那么从 horse 到 ros 就是 horse -> roe -> ros
 *      (如果最后一个字母相同则不需要任何操作，如果最后一个字母不同，则需要一部操作替换、删除或插入操作及z + 1）
 *      即 dp[i - 1][j - 1] + int(word1[i]!=word2[j])
 *
 *  根据以上三种情况，可以分为
 *   word1[i] == word2[j]  dp[i][j] = dp[i - 1][j - 1];
 *   dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1
 */
public class LeetCode72 {

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= m; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
            }
        }
        return dp[n][m];
    }

}
