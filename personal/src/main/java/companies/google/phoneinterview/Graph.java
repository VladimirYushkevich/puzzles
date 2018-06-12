package companies.google.phoneinterview;

import java.util.*;

public class Graph {
    private Map<Integer, Node> nodeLookup = new HashMap<>();

    public static class Node {
        private int id;
        private LinkedList<Node> adjacent = new LinkedList<>();

        Node(int id) {
            this.id = id;
        }
    }

    private Node getNode(int id) {
        Node node = nodeLookup.get(id);
        if (node == null) {
            node = new Node(id);
            nodeLookup.put(id, node);
        }
        return node;
    }

    void addEdge(int source, int destination) {
        Node s = getNode(source);
        Node d = getNode(destination);
        s.adjacent.add(d);
    }

    List<Integer> getBFSPath(int source, int destination) {
        ArrayList<Integer> path = new ArrayList<>();

        LinkedList<Integer> nextToVisit = new LinkedList<>();
        nextToVisit.add(source);

        Set<Integer> visited = new HashSet<>();
        while (!nextToVisit.isEmpty()) {
            Integer nextNodeId = nextToVisit.poll();
            path.add(nextNodeId);

            if (nextNodeId == destination) {
                return path;
            }

            if (visited.contains(nextNodeId)) {
                continue;
            }
            visited.add(nextNodeId);

            for (Node child : getNode(nextNodeId).adjacent) {
                nextToVisit.add(child.id);
            }
        }

        return path;
    }

    List<Integer> getDFSPath(int source, int destination) {
        Node s = getNode(source);
        Node d = getNode(destination);
        Set<Integer> visited = new HashSet<>();
        ArrayList<Integer> path = new ArrayList<>();

        hasDfsPath(s.id, d.id, visited, path);

        return path;
    }

    private boolean hasDfsPath(int source, int destination, Set<Integer> visited, ArrayList<Integer> path) {
        if (visited.contains(source)) {
            return false;
        }

        visited.add(source);
        path.add(source);

        if (source == destination) {
            return true;
        }

        for (Node child : getNode(source).adjacent) {
            if (hasDfsPath(child.id, destination, visited, path)) {
                return true;
            }
        }

        return false;
    }
}
