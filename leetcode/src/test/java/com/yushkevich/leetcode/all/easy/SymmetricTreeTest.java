package com.yushkevich.leetcode.all.easy;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SymmetricTreeTest {

    private SymmetricTree solution = new SymmetricTree();

    @Test
    public void exampleOne() {
        SymmetricTree.TreeNode left = new SymmetricTree.TreeNode(2,
                new SymmetricTree.TreeNode(3),
                new SymmetricTree.TreeNode(4));
        SymmetricTree.TreeNode right = new SymmetricTree.TreeNode(2,
                new SymmetricTree.TreeNode(4),
                new SymmetricTree.TreeNode(3));
        SymmetricTree.TreeNode root = new SymmetricTree.TreeNode(1, left, right);

        assertTrue(solution.isSymmetric(root));
    }

    @Test
    public void exampleTwo() {
        SymmetricTree.TreeNode left = new SymmetricTree.TreeNode(2,
                null, new SymmetricTree.TreeNode(3));
        SymmetricTree.TreeNode right = new SymmetricTree.TreeNode(2,
                null, new SymmetricTree.TreeNode(3));
        SymmetricTree.TreeNode root = new SymmetricTree.TreeNode(1, left, right);

        assertFalse(solution.isSymmetric(root));
    }

    @Test
    public void exampleThree() {
        assertTrue(solution.isSymmetric(null));
    }
}
