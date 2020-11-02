package com.leetcode.dynamic;

import java.util.Arrays;
import java.util.Comparator;

/**
 *  * 实例LeetCode354
 *  * 354. 俄罗斯套娃信封问题
 *  * @version 1.0
 *  https://leetcode-cn.com/problems/russian-doll-envelopes/
 *
 * 给定一些标记了宽度和高度的信封，
 * 宽度和高度以整数对形式 (w, h) 出现。
 * 当另一个信封的宽度和高度都比这个信封大的时候，
 * 这个信封就可以放进另一个信封里，
 * 如同俄罗斯套娃一样。
 *
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 *  说明:
 *  不允许旋转信封
 *
 *  输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 *  输出: 3
 *  解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 *
 *  先对envelopes进行排序，先通过w，在通过h进行升序排序
 *  dp[i] 代表 以第(Wi, Hi)结尾的最长上升子序列
 *      dp[i] = max(1, dp[j] + 1), j < i, Wj < Wi, Hj < Hi
 */
public class LeetCode354 {

    public int maxEnvelopes1(int[][] envelopes) {

        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        int[] dp = new int[envelopes.length];
        int ans = 0;
        for (int i = 0; i < envelopes.length; ++i) {
            int tmp = 1;
            for (int j = 0; j < i; ++j) {
                if (envelopes[i][0] > envelopes[j][0]
                        && envelopes[i][1] > envelopes[j][1]) {
                    tmp = Math.max(dp[j] + 1, tmp);
                }
            }
            dp[i] = tmp;
            ans = Math.max(ans, tmp);
        }
        return ans;
    }

    public int maxEnvelopes(int[][] envelopes) {
        //按照w升序，按照h降序。
        // 如[[1，3]，[1，4]，[1，5]，[2，3]]，
        // 如果我们直接对 h 进行 LIS 算法，我们将会得到 [3，4，5]
        // ---------
        // 若 w 相同则按 h 降序排序 [[1, 5], [1, 4], [1, 3], [2, 3]]
        // 在对h进行LIS算法，再对 h 进行 LIS 算法可以得到 [5]，长度为 1
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });
        int[] secondDim = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; ++i) {
            secondDim[i] = envelopes[i][1];
        }
        return lengthOfLIS(secondDim);
    }

    private int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int maxL = 0;
        for (int num : nums) {
            int index = Arrays.binarySearch(dp, 0, maxL, num);
            index = index < 0 ? - index - 1 : index;
            dp[index] = num;
            if (index == maxL) {
                maxL++;
            }
        }
        return maxL;
    }
}
