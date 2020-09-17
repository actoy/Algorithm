package com.leetcode;

/**
 *  * 实例Offer54
 *  *
 *  * @version 1.0
 *  剑指 Offer 54. 二叉搜索树的第k大节点
 *  https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 *  给定一棵二叉搜索树，请找出其中第k大的节点。
 */
public class Offer54 {
    public int kthLargest(TreeNode root, int k) {
        int right = depth(root.right);

        if(k == right + 1) {
            return root.val;
        } else if (k > right) {
            return kthLargest(root.left, k - right - 1);
        } else {
            return kthLargest(root.right, k);
        }
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return (depth(root.left) + depth(root.right)) + 1;
    }
}
