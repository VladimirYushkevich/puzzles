package com.yushkevich.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * 1
 * /  \
 * 2   3
 * \   \
 * 5   4
 * -> 1, 3, 4
 */
public class BinaryTreeRightSideView {

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> path = new ArrayList<>();

        travers(root, path, 0);

        return path;
    }

    private static void travers(TreeNode node, List<Integer> path, int currDepth) {
        if (node == null) return;

        if (currDepth == path.size()) {
            path.add(node.val);
        }

        travers(node.right, path, currDepth + 1);
        travers(node.left, path, currDepth + 1);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
