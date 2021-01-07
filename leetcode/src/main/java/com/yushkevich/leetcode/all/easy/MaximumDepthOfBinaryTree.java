package com.yushkevich.leetcode.all.easy;

public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        return rec(root, 0);
    }

    private int rec(TreeNode root, int depth) {
        if (root == null) return depth;
        depth++;
        int leftDepth = rec(root.left, depth);
        int rightDepth = rec(root.right, depth);
        return Math.max(leftDepth, rightDepth);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }
}
