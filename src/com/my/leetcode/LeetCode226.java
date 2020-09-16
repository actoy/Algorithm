package com.my.leetcode;

/**
 *  * 实例LeetCode226
 *  *
 *  * @version 1.0
 *  翻转二叉树，[4,2,7,1,3,6,9]
 *        4             4
 *      2   7    =>    7  2
 *    1  3 6 9        9 6 3 1
 */
public class LeetCode226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmpNode = root.left;
        root.left = root.right;
        root.right = tmpNode;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}

