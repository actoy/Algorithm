package com.my.leetcode;

/**
 *  * 实例LeetCode4
 *  * 寻找两个正序数组的中位数
 *  * 要求算法的时间复杂度为 O(log(m + n))
 *  * @version 1.0
 */
public class LeetCode4 {
    public static void main(String[] args) {
        int[] num1 = {1, 2};
        int[] num2 = {3, 4};
        System.out.println( findMedianSortedArrays(num1, num2) );
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int mid = (length1 + length2 + 1) / 2;
        if ((length1 + length2) % 2 == 1) {
            return getKthNumber(nums1, 0, length1 - 1, nums2, 0, length2 - 1, mid);
        } else {
            return (getKthNumber(nums1, 0, length1 - 1, nums2, 0, length2 - 1, mid)
                    + getKthNumber(nums1, 0, length1 - 1, nums2, 0, length2 - 1, mid + 1)) * 0.5;
        }
    }

    private static int getKthNumber(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int length1 = end1 - start1 + 1;
        int length2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (length1 > length2) {
            return getKthNumber(nums2, start2, end2, nums1, start1, end1, k);
        }
        if (length1 == 0) {
            return nums2[k + start2 - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int i = start1 + Math.min(length1, k / 2) - 1;
        int j = start2 + Math.min(length2, k / 2) - 1;
        if (nums1[i] > nums2[j]) {
            return getKthNumber(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
        return getKthNumber(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
    }

}