package com.yushkevich.leetcode.trees;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TrimABinarySearchTreeTest {

    private TrimABinarySearchTree testee = new TrimABinarySearchTree();


    @Test
    public void trimBST() {
//        TrimABinarySearchTree.TreeNode root1 = new TrimABinarySearchTree.TreeNode(1);
//        root1.left = new TrimABinarySearchTree.TreeNode(0);
//        root1.right = new TrimABinarySearchTree.TreeNode(2);
//        TrimABinarySearchTree.TreeNode res1 = testee.trimBST(root1, 1, 2);
//        assertThat(res1.val, is(1));

        TrimABinarySearchTree.TreeNode root2 = new TrimABinarySearchTree.TreeNode(3);
        final TrimABinarySearchTree.TreeNode left1 = new TrimABinarySearchTree.TreeNode(0);
        root2.left = left1;
        root2.right = new TrimABinarySearchTree.TreeNode(4);
        TrimABinarySearchTree.TreeNode right2 = new TrimABinarySearchTree.TreeNode(2);
        right2.left = new TrimABinarySearchTree.TreeNode(1);
        left1.right = right2;

        TrimABinarySearchTree.TreeNode res2 = testee.trimBST(root2, 1, 3);
        assertThat(res2.val, is(3));
    }
}
