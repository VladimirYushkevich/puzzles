package cci;

import commons.BaseTest;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

import static cci.ShortestReachInAGraph.solution;
import static java.util.stream.Collectors.joining;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertArrayEquals;

public class ShortestReachInAGraphTest extends BaseTest {

    private static final String PATH = "cci/graph";

    /**
     * Example
     *
     *           1   2 4
     *         /  \
     *        3 - 5
     *         \
     *         6
     *
     *      Starting: 3
     *      1-3=>1
     *      2-3=>0
     *      3-4=>0
     *      3-5=>{1,2}
     *      3-6=>1
     *
     */
    @Test
    public void nameShortestReach() {
        ShortestReachInAGraph.Graph graph = new ShortestReachInAGraph.Graph(6, 6);
        graph.addEdge(1, 3);
        graph.addEdge(1, 5);
        graph.addEdge(3, 5);
        graph.addEdge(3, 6);
        assertArrayEquals(new int[]{6, -1, -1, 6, 6}, graph.shortestReach(3));

        ShortestReachInAGraph.Graph graph1 = new ShortestReachInAGraph.Graph(4, 6);
        graph1.addEdge(1, 2);
        graph1.addEdge(1, 3);
        assertArrayEquals(new int[]{6, 6, -1}, graph1.shortestReach(1));

        ShortestReachInAGraph.Graph graph2 = new ShortestReachInAGraph.Graph(3, 6);
        graph2.addEdge(2, 3);
        assertArrayEquals(new int[]{-1, 6}, graph2.shortestReach(2));
    }

    @Test
    public void test() throws Exception {
        runTestCase(0);
        runTestCase(1);
    }

    private void runTestCase(int id) throws IOException {
        List<String> inputs = getParameters(PATH, "input", id);
        List<String> outputs = getParameters(PATH, "output", id);

        long start = System.currentTimeMillis();

        Iterator<String> iterator = inputs.iterator();

        int queries = Integer.valueOf(iterator.next());
        int[] sizes = new int[queries];
        int[] startIds = new int[queries];
        Map<Integer, List<ShortestReachInAGraph.Edge>> edgesToQuery = new HashMap<>();

        for (int t = 0; t < queries; t++) {
            String[] sizeOfGraph = iterator.next().split(" ");
            sizes[t] = Integer.valueOf(sizeOfGraph[0]);
            int m = Integer.valueOf(sizeOfGraph[1]);

            List<ShortestReachInAGraph.Edge> edges = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                String[] edge = iterator.next().split(" ");
                int u = Integer.valueOf(edge[0]);
                int v = Integer.valueOf(edge[1]);
                edges.add(new ShortestReachInAGraph.Edge(u, v));
            }
            edgesToQuery.put(t, edges);

            startIds[t] = Integer.valueOf(iterator.next());
        }

        Map<Integer, int[]> solution = solution(queries, sizes, startIds, edgesToQuery);
        for (int i = 0; i < queries; i++) {
            String actual = Arrays.stream(solution.get(i))
                    .mapToObj(Integer::toString)
                    .collect(joining(" "));
            assertThat(actual, is(outputs.get(i)));
        }

        System.out.println(String.format("ShortestReachInAGraphTest Test Case [%s] finished after [%s] s", id,
                (System.currentTimeMillis() - start) / 1000.0d));
    }
}
