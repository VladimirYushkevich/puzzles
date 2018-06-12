package algorithms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import static java.util.Objects.nonNull;

/**
 * Breadth-first search over the tree.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TreeTraversing {

    private BinaryTree binaryTree;

    /**
     * Breadth-first search over the tree.
     */
    List<Integer> getBFS() {
        List<Integer> traces = new ArrayList<>();

        Deque<Node> visited = new LinkedList<>();

        final Node root = binaryTree.getRoot();
        visited.push(root);

        traversingByBFS(visited, traces);

        return traces;
    }

    /**
     * Depth-first search over the tree.
     */
    List<Integer> getDFS() {
        List<Integer> traces = new ArrayList<>();

        Deque<Node> visited = new LinkedList<>();

        final Node root = binaryTree.getRoot();
        visited.push(root);

        traversingByDFS(visited, traces);

        return traces;
    }

    private void traversingByBFS(Deque<Node> visited, List<Integer> traces) {
        if (!visited.isEmpty()) {

            final Node node = visited.pollFirst();

            assert node != null;
            traces.add(node.getKey());

            final Node left = node.getLeft();
            if (nonNull(left)) {
                visited.addLast(left);
            }

            final Node right = node.getRight();
            if (nonNull(right)) {
                visited.addLast(right);
            }

            traversingByBFS(visited, traces);
        }
    }

    private void traversingByDFS(Deque<Node> visited, List<Integer> traces) {
        if (!visited.isEmpty()) {

            final Node node = visited.pollFirst();

            assert node != null;
            traces.add(node.getKey());

            final Node right = node.getRight();
            if (nonNull(right)) {
                visited.addFirst(right);
            }

            final Node left = node.getLeft();
            if (nonNull(left)) {
                visited.addFirst(left);
            }

            traversingByDFS(visited, traces);
        }
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    static class BinaryTree {
        private Node root;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Node {
        private int key;
        private Node left;
        private Node right;
    }
}
