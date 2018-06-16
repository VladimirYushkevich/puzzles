package ccic;

import ccic.DetectACycle;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class DetectACycleTest {

    private DetectACycle detectACycle;

    @Before
    public void setUp() {
        detectACycle = new DetectACycle();
    }

    @Test
    public void testNoCycle() {
        DetectACycle.Node node = new DetectACycle().new Node();
        assertFalse(detectACycle.hasCycle(node));
    }

    @Test
    public void testCycle() {
        DetectACycle.Node node1 = new DetectACycle().new Node();
        DetectACycle.Node node2 = new DetectACycle().new Node();
        DetectACycle.Node node3 = new DetectACycle().new Node();
        node1.next = node2;
        node2.next = node3;
        node3.next = node2;

        assertTrue(detectACycle.hasCycle(node1));
    }
}
