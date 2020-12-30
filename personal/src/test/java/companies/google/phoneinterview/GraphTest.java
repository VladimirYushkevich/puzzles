package companies.google.phoneinterview;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class GraphTest {

    private Graph graph;

    /**
     * 2
     * /     \
     * 1 - 3 - 4
     * \  |  /
     * 5
     */
    @Before
    public void setUp() {
        graph = new Graph();

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 5);

        graph.addEdge(2, 1);
        graph.addEdge(2, 4);

        graph.addEdge(3, 1);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);

        graph.addEdge(4, 2);
        graph.addEdge(4, 3);
        graph.addEdge(4, 5);

        graph.addEdge(5, 1);
        graph.addEdge(5, 3);
        graph.addEdge(5, 4);
    }

    @Test
    public void shouldReturnBFSPath() {
        assertArrayEquals(graph.getBFSPath(1, 5).toArray(), Arrays.asList(1, 2, 3, 5).toArray());
    }

    @Test
    public void shouldReturnDFSPath() {
        assertArrayEquals(graph.getDFSPath(1, 5).toArray(), Arrays.asList(1, 2, 4, 3, 5).toArray());
    }
}
