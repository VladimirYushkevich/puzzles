package ccic.algorithms;

import java.util.*;

public class ShortestReachInAGraph {

    static class Edge {
        int from;
        int to;

        Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }

    public static class Graph {
        private int weight;
        private Map<Integer, List<Integer>> adj;
        private boolean[] marked;  // marked[v] = is there an s->v path?
        private int[] edgeTo;      // edgeTo[v] = last edge on shortest s->v path
        private int[] distTo;      // distTo[v] = length of shortest s->v path

        Graph(int size, int weight) {
            this.weight = weight;
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
            edgeTo = new int[length];
            traversal.add(s);
            while (!traversal.isEmpty()) {
                int v = traversal.poll();
                for (int w : adj.get(v)) {
                    if (!marked[w]) {
                        edgeTo[w] = v;
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

        int[] shortestReach(int startId) {
            bfs(startId - 1);

            int length = distTo.length;
            int[] res = new int[length - 1];
            int index = 0;
            for (int i = 0; i < length; i++) {
                if ((i + 1) == startId) {
                    continue;
                }
                int dist = this.distTo[i];
                res[index] = dist > 0 ? weight * dist : -1;
                index++;
            }

            return res;
        }
    }

    static Map<Integer, int[]> solution(int queries, int[] sizes, int[] startIds, Map<Integer, List<Edge>> edgesToQuery) {
        Map<Integer, int[]> res = new HashMap<>();

        for (int i = 0; i < queries; i++) {

            // Create a graph of size i where each edge weight is 6:
            Graph graph = new Graph(sizes[i], 6);

            // read and set edges
            for (Edge edge : edgesToQuery.get(i)) {
                // add each edge to the graph
                graph.addEdge(edge.from, edge.to);
            }

            // Find shortest reach from node s
            int startId = startIds[i];
            int[] distances = graph.shortestReach(startId);

            res.put(i, distances);
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int queries = scanner.nextInt();
        int[] sizes = new int[queries];
        int[] startIds = new int[queries];
        Map<Integer, List<Edge>> edgesToQuery = new HashMap<>();

        for (int t = 0; t < queries; t++) {
            sizes[t] = scanner.nextInt();
            int m = scanner.nextInt();

            List<Edge> edges = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                edges.add(new Edge(u, v));
            }
            edgesToQuery.put(t, edges);

            startIds[t] = scanner.nextInt();
        }

        scanner.close();


        Map<Integer, int[]> solution = solution(queries, sizes, startIds, edgesToQuery);
        for (int[] distances : solution.values()) {
            for (int distance : distances) {
                System.out.print(distance);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
