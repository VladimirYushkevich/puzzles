package companies.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2021One {

    public static int connectedSum(int n, List<String> edges) {

        Graph g = new Graph(n);

        for (String edge : edges) {
            String[] pairs = edge.split(" ");
            g.addEdge(Integer.parseInt(pairs[0]), Integer.parseInt(pairs[1]));
        }


        return g.connectedComponents();
    }

    public static class Graph {
        int numberOfVertices;
        Map<Integer, List<Integer>> adj;

        Graph(int numberOfVertices) {
            this.numberOfVertices = numberOfVertices;
            adj = new HashMap<>();

            for (int i = 0; i <= numberOfVertices; i++) {
                List<Integer> value = new ArrayList<>();
                value.add(i);
                adj.put(i, value);
            }
        }

        void addEdge(int src, int dest) {
            adj.get(src).add(dest);

            // since graph is undirected, add an edge from dest to src also
            adj.put(dest, adj.get(src));
        }

        int DFSUtil(int v, boolean[] visited, int size) {
            visited[v] = true;
            size++;

            for (int x : adj.get(v)) {
                if (!visited[x])
                    return DFSUtil(x, visited, size);
            }

            return size;
        }

        int connectedComponents() {
            // Mark all the vertices as not visited
            boolean[] visited = new boolean[numberOfVertices + 1];
            int res = 0;
            for (int v = 1; v <= numberOfVertices; v++) {
                if (!visited[v]) {
                    int total = DFSUtil(v, visited, 0);
                    res += (int) Math.ceil(Math.sqrt(total));
                }
            }

            return res;
        }
    }

}
