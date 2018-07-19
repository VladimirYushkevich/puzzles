package companies.amazon;

import java.util.*;

public class BST {

    int bstDistanceWithGraph(int[] values, int n, int node1, int node2) {
        if(node1 == node2) {
            return 0;
        }

        if (n > values.length) {
            return -1;
        }

        Graph graph = new Graph(n);
        Tree tree = new Tree(null);
        for (int i = 0; i < n; i++) {
            int value = values[i];
            Node root = tree.getRoot();
            if (root == null) {
                tree.setRoot(new Node(value, null, null));
            } else {
                insertInGraph(root, value, graph);
            }
        }

        return graph.shortestPath(node1, node2);
    }

    private void insertInGraph(Node node, int value, Graph graph) {
        final int nodeValue = node.getValue();
        if (value < nodeValue) {
            Node leftNode = node.getLeft();
            if (leftNode == null) {
                graph.addEdge(nodeValue, value);
                node.setLeft(new Node(value, null, null));
            } else {
                insertInGraph(leftNode, value, graph);
            }
        } else {
            Node rightNode = node.getRight();
            if (rightNode == null) {
                graph.addEdge(nodeValue, value);
                node.setRight(new Node(value, null, null));
            } else {
                graph.addEdge(rightNode.getValue(), nodeValue);
                insertInGraph(rightNode, value, graph);
            }
        }

    }

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

    class Graph {
        private Map<Integer, List<Integer>> adj;
        private boolean[] marked;
        private int[] distTo;

        Graph(int size) {
            adj = new HashMap<>(size);
            for (int v = 0; v < size; v++) {
                adj.put(v, new ArrayList<>());
            }
        }

        private void bfs(int s) {
            Queue<Integer> traversal = new LinkedList<>();
            int length = adj.size();
            marked = new boolean[length];
            distTo = new int[length];
            traversal.add(s);
            while (!traversal.isEmpty()) {
                int v = traversal.poll();
                for (int w : adj.get(v)) {
                    if (!marked[w]) {
                        distTo[w] = distTo[v] + 1;
                        marked[w] = true;
                        traversal.add(w);
                    }
                }
            }
        }

        void addEdge(int first, int second) {
            List<Integer> firstEdges = adj.get(first - 1);
            firstEdges.add(second - 1);

            List<Integer> secondEdges = adj.get(second - 1);
            secondEdges.add(first - 1);
        }

        private int shortestPath(int startId, int endId) {
            if (startId > adj.size()) {
                return -1;
            }

            bfs(startId - 1);

            return endId <= distTo.length ? distTo[endId - 1] : -1;
        }
    }
}
