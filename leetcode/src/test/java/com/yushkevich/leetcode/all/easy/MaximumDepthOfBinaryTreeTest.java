package com.yushkevich.leetcode.all.easy;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MaximumDepthOfBinaryTreeTest {

    private MaximumDepthOfBinaryTree solution = new MaximumDepthOfBinaryTree();

    @Test
    public void exampleOne() {
        MaximumDepthOfBinaryTree.TreeNode left = new MaximumDepthOfBinaryTree.TreeNode(9);
        MaximumDepthOfBinaryTree.TreeNode right = new MaximumDepthOfBinaryTree.TreeNode(20,
                new MaximumDepthOfBinaryTree.TreeNode(15),
                new MaximumDepthOfBinaryTree.TreeNode(7));
        MaximumDepthOfBinaryTree.TreeNode root = new MaximumDepthOfBinaryTree.TreeNode(9, left, right);

        assertThat(solution.maxDepth(root), is(3));
    }

    @Test
    public void exampleTwo() {
        MaximumDepthOfBinaryTree.TreeNode right = new MaximumDepthOfBinaryTree.TreeNode(2);
        MaximumDepthOfBinaryTree.TreeNode root = new MaximumDepthOfBinaryTree.TreeNode(1, null, right);

        assertThat(solution.maxDepth(root), is(2));
    }

    @Test
    public void exampleThree() {
        MaximumDepthOfBinaryTree.TreeNode root = new MaximumDepthOfBinaryTree.TreeNode(0, null, null);

        assertThat(solution.maxDepth(root), is(1));
    }

    @Test
    public void exampleFour() {
        assertThat(solution.maxDepth(null), is(0));
    }
}
