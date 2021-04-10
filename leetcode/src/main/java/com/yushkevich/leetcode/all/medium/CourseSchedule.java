package com.yushkevich.leetcode.all.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph graph = new Graph(numCourses);
        for (int[] prerequisite : prerequisites) {
            graph.addEdge(prerequisite[0], prerequisite[1]);
        }
        return !graph.isCyclic();
    }

    private class Graph {

        private final int V;
        private final List<List<Integer>> adj;

        public Graph(int V) {
            this.V = V;
            adj = new ArrayList<>(V);

            for (int i = 0; i < V; i++)
                adj.add(new LinkedList<>());
        }

        private boolean isCyclicRec(int i, boolean[] visited,
                                    boolean[] recStack) {
            if (recStack[i])
                return true;

            if (visited[i])
                return false;

            visited[i] = true;

            recStack[i] = true;
            List<Integer> children = adj.get(i);

            for (Integer c : children)
                if (isCyclicRec(c, visited, recStack))
                    return true;

            recStack[i] = false;

            return false;
        }

        private void addEdge(int source, int dest) {
            adj.get(source).add(dest);
        }

        private boolean isCyclic() {
            boolean[] visited = new boolean[V];
            boolean[] recStack = new boolean[V];

            for (int i = 0; i < V; i++)
                if (isCyclicRec(i, visited, recStack))
                    return true;

            return false;
        }
    }
}
