package companies.amazon;

public class BST {

    public int bstDistance(int[] values, int n, int node1, int node2) {
        if (n > values.length) {
            return -1;
        }

        Tree tree = new Tree(null);
        for (int i = 0; i < n; i++) {
            int value = values[i];
            Node root = tree.getRoot();
            if (root == null) {
                tree.setRoot(new Node(value, null, null));
            } else {
                insert(root, value);
            }
        }

        final int startNodeValue = findNodeValue(tree.getRoot(), node1);
        if (startNodeValue < 0) {
            return -1;
        }

        final int endNodeValue = findNodeValue(tree.getRoot(), node2);
        if (endNodeValue < 0) {
            return -1;
        }

        final int rootStartNodeValue = findRootNodeValue(tree.getRoot(), startNodeValue);
        final int rootEndNodeValue = findRootNodeValue(tree.getRoot(), endNodeValue);

        if (rootStartNodeValue < rootEndNodeValue) {
            return getDistance(tree.getRoot(), rootStartNodeValue, rootEndNodeValue);
        } else {
            return getDistance(tree.getRoot(), rootEndNodeValue, rootStartNodeValue);
        }
    }

    private int findRootNodeValue(Node root, int value) {
        if (root == null) {
            return -1;
        }

        final Node left = root.getLeft();
        if (left != null && left.getValue() == value) {
            return root.getValue();
        }

        final Node right = root.getRight();
        if (right != null && right.getValue() == value) {
            return root.getValue();
        }

        if (root.getValue() > value) {
            return findRootNodeValue(root.getLeft(), value);
        } else {
            return findRootNodeValue(root.getRight(), value);
        }
    }

    private int getDistance(Node root, int leftRootValue, int rightRootValue) {
        int count = 2;

        int value = leftRootValue;
        while (value != rightRootValue) {
            count++;
            value = findRootNodeValue(root, value);
        }

        return count;

    }

    private int findNodeValue(Node node, int value) {
        if (node == null) {
            return -1;
        }

        final int nodeValue = node.getValue();

        if (nodeValue == value) {
            return nodeValue;
        }

        if (nodeValue > value) {
            return findNodeValue(node.getLeft(), value);
        } else {
            return findNodeValue(node.getRight(), value);
        }
    }

    private void insert(Node node, int value) {
        if (value < node.getValue()) {
            Node leftNode = node.getLeft();
            if (leftNode == null) {
                node.setLeft(new Node(value, null, null));
            } else {
                insert(leftNode, value);
            }
        } else {
            Node rightNode = node.getRight();
            if (rightNode == null) {
                node.setRight(new Node(value, null, null));
            } else {
                insert(rightNode, value);
            }
        }

    }

    private class Tree {
        Node root;

        Tree(Node root) {
            this.root = root;
        }

        Node getRoot() {
            return this.root;
        }

        void setRoot(Node root) {
            this.root = root;
        }
    }

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        int getValue() {
            return this.value;
        }

        void setValue(int value) {
            this.value = value;
        }

        Node getLeft() {
            return this.left;
        }

        void setLeft(Node left) {
            this.left = left;
        }

        Node getRight() {
            return this.right;
        }

        void setRight(Node right) {
            this.right = right;
        }
    }
}
