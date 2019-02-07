package companies.careem;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class BST {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        createBST(a);
    }

    private static void createBST(int[] keys) {
        AtomicInteger counter = new AtomicInteger(0);
        BinarySearchTree binarySearchTree = new BinarySearchTree(null);

        for (int key : keys) {
            final Node root = binarySearchTree.getRoot();
            if (root != null) {
                insert(root, key, counter);
            } else {
                binarySearchTree.setRoot(new Node(key, null, null));
            }
        }

        System.out.println(counter);
    }

    private static void insert(Node root, int key, AtomicInteger counter) {
        counter.incrementAndGet();
        if (key < root.getKey()) {
            Node leftNode = root.getLeft();
            if (leftNode == null) {
                root.setLeft(new Node(key, null, null));
            } else {
                insert(leftNode, key, counter);
            }
        } else {
            Node rightNode = root.getRight();
            if (rightNode == null) {
                root.setRight(new Node(key, null, null));
            } else {
                insert(rightNode, key, counter);
            }
        }
    }

    private static class BinarySearchTree {
        private Node root;

        public BinarySearchTree(Node root) {
            this.root = root;
        }

        public Node getRoot() {
            return root;
        }

        public void setRoot(Node root) {
            this.root = root;
        }
    }

    private static class Node {
        private int key;
        private Node left;
        private Node right;

        public Node(int key, Node left, Node right) {
            this.key = key;
            this.left = left;
            this.right = right;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}
