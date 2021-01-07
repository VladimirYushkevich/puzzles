package com.yushkevich.leetcode.all.easy;

import java.util.Stack;

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return rec(root, root);
    }

    private boolean rec(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return (left.val == right.val)
                && rec(left.right, right.left)
                && rec(left.left, right.right);
    }

    private boolean loop(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> leftNodes = new Stack<>();
        leftNodes.push(root.left);
        Stack<TreeNode> rightNodes = new Stack<>();
        rightNodes.push(root.right);

        while (!leftNodes.isEmpty() && !rightNodes.isEmpty()) {
            TreeNode left = leftNodes.pop();
            TreeNode right = rightNodes.pop();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null || left.val != right.val) {
                return false;
            }
            leftNodes.push(left.left);
            leftNodes.push(left.right);
            rightNodes.push(right.right);
            rightNodes.push(right.left);
        }
        return true;
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
