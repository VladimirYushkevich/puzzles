package cci;

import lombok.AllArgsConstructor;

public class IsThisBinarySearchTree {

    boolean checkBST(Node root) {
        return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean check(Node n, int min, int max) {
        return n == null || !(n.data <= min || n.data >= max)
                && check(n.left, min, n.data) && check(n.right, n.data, max);
    }

    @AllArgsConstructor
    class Node {
        int data;
        Node left;
        Node right;
    }
}
