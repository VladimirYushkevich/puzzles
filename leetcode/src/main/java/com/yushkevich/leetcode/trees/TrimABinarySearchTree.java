package com.yushkevich.leetcode.trees;

public class TrimABinarySearchTree {

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;
        if (root.val > R) return trimBST(root.left, L, R);
        if (root.val < L) return trimBST(root.right, L, R);

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }

    public static class TreeNode {
        int val;
        TrimABinarySearchTree.TreeNode left;
        TrimABinarySearchTree.TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "val->" + val + ",left->" + ((left == null) ? "null" : left.val) + ",right->" + ((right == null) ? "null" : right.val);
        }
    }
}
