package com.yushkevich.leetcode.trees;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BinaryTreeRightSideViewTest {

    @Test
    public void printRightView() {
        BinaryTreeRightSideView.TreeNode leftRight = new BinaryTreeRightSideView.TreeNode(5, null, null);
        BinaryTreeRightSideView.TreeNode left = new BinaryTreeRightSideView.TreeNode(2, null, leftRight);

        BinaryTreeRightSideView.TreeNode rightRight = new BinaryTreeRightSideView.TreeNode(4, null, null);
        BinaryTreeRightSideView.TreeNode right = new BinaryTreeRightSideView.TreeNode(3, null, rightRight);
        BinaryTreeRightSideView.TreeNode root = new BinaryTreeRightSideView.TreeNode(1, left, right);

        assertEquals(List.of(1, 3, 4), BinaryTreeRightSideView.rightSideView(root));
    }

    @Test
    public void printRightViewExample2() {
        BinaryTreeRightSideView.TreeNode right = new BinaryTreeRightSideView.TreeNode(3, null, null);
        BinaryTreeRightSideView.TreeNode root = new BinaryTreeRightSideView.TreeNode(1, null, right);

        assertEquals(List.of(1, 3), BinaryTreeRightSideView.rightSideView(root));
    }

    @Test
    public void printRightViewExample3() {
        assertEquals(Collections.emptyList(), BinaryTreeRightSideView.rightSideView(null));
    }

    @Test
    public void printRightViewExample5() {
        BinaryTreeRightSideView.TreeNode root = new BinaryTreeRightSideView.TreeNode(1);
        root.left = new BinaryTreeRightSideView.TreeNode(2);
        root.left.right = new BinaryTreeRightSideView.TreeNode(4);
        root.right = new BinaryTreeRightSideView.TreeNode(3);
        root.right.left = new BinaryTreeRightSideView.TreeNode(5);
        root.right.right = new BinaryTreeRightSideView.TreeNode(6);
        root.right.left.left = new BinaryTreeRightSideView.TreeNode(7);
        root.right.left.right = new BinaryTreeRightSideView.TreeNode(8);

        assertEquals(List.of(1, 3, 6, 8), BinaryTreeRightSideView.rightSideView(root));
    }
}
