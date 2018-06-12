package algorithms;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class TreeTraversingTest {

    private TreeTraversing treeTraversing;

    /**
     *      1    layer 0
     *    /  \
     *   2   3   layer 1
     *  /\  /\
     * 3 5 6 7   layer 2
     */
    @Before
    public void setUp() {

        TreeTraversing.Node nodeLayer2_0 = new TreeTraversing.Node(3, null, null);
        TreeTraversing.Node nodeLayer2_1 = new TreeTraversing.Node(5, null, null);
        TreeTraversing.Node nodeLayer2_2 = new TreeTraversing.Node(6, null, null);
        TreeTraversing.Node nodeLayer2_3 = new TreeTraversing.Node(7, null, null);

        TreeTraversing.Node nodeLayer1_0 = new TreeTraversing.Node(2, nodeLayer2_0, nodeLayer2_1);
        TreeTraversing.Node nodeLayer1_1 = new TreeTraversing.Node(3, nodeLayer2_2, nodeLayer2_3);

        TreeTraversing.Node nodeLayer0_0 = new TreeTraversing.Node(1, nodeLayer1_0, nodeLayer1_1);

        treeTraversing = new TreeTraversing(new TreeTraversing.BinaryTree(nodeLayer0_0));
    }

    @Test
    public void testGetBFS() {
        assertArrayEquals(treeTraversing.getBFS().toArray(), Arrays.asList(1, 2, 3, 3, 5, 6, 7).toArray());
    }

    @Test
    public void testGetDFS()  {
        assertArrayEquals(treeTraversing.getDFS().toArray(), Arrays.asList(1, 2, 3, 5, 3, 6, 7).toArray());
    }
}
