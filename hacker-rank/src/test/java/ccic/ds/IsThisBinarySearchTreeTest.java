package ccic.ds;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IsThisBinarySearchTreeTest {

    private IsThisBinarySearchTree tree;
    private IsThisBinarySearchTree.Node root;

    /**
     * 4    layer 0
     * /  \
     * 2   6   layer 1
     * /\  /\
     * 1 3 5 7   layer 2
     */
    @Before
    public void setUp() {
        tree = new IsThisBinarySearchTree();
    }

    @Test
    public void testCheckBST() {
        IsThisBinarySearchTree.Node nodeLayer2_0 = tree.new Node(1, null, null);
        IsThisBinarySearchTree.Node nodeLayer2_1 = tree.new Node(3, null, null);
        IsThisBinarySearchTree.Node nodeLayer2_2 = tree.new Node(5, null, null);
        IsThisBinarySearchTree.Node nodeLayer2_3 = tree.new Node(7, null, null);

        IsThisBinarySearchTree.Node nodeLayer1_0 = tree.new Node(2, nodeLayer2_0, nodeLayer2_1);
        IsThisBinarySearchTree.Node nodeLayer1_1 = tree.new Node(6, nodeLayer2_2, nodeLayer2_3);

        root = tree.new Node(4, nodeLayer1_0, nodeLayer1_1);

        assertTrue(tree.checkBST(root));
    }

    @Test
    public void testCheckBST_fail_leftNodeValueHigherThanRightNodeValue() {
        IsThisBinarySearchTree.Node nodeLayer2_0 = tree.new Node(1, null, null);
        IsThisBinarySearchTree.Node nodeLayer2_1 = tree.new Node(3, null, null);
        IsThisBinarySearchTree.Node nodeLayer2_2 = tree.new Node(7, null, null);
        IsThisBinarySearchTree.Node nodeLayer2_3 = tree.new Node(5, null, null);

        IsThisBinarySearchTree.Node nodeLayer1_0 = tree.new Node(2, nodeLayer2_0, nodeLayer2_1);
        IsThisBinarySearchTree.Node nodeLayer1_1 = tree.new Node(6, nodeLayer2_2, nodeLayer2_3);

        root = tree.new Node(4, nodeLayer1_0, nodeLayer1_1);

        assertFalse(tree.checkBST(root));
    }

    @Test
    public void testCheckBST_fail_duplicates() {
        IsThisBinarySearchTree.Node nodeLayer2_0 = tree.new Node(1, null, null);
        IsThisBinarySearchTree.Node nodeLayer2_1 = tree.new Node(3, null, null);
        IsThisBinarySearchTree.Node nodeLayer2_2 = tree.new Node(5, null, null);
        IsThisBinarySearchTree.Node nodeLayer2_3 = tree.new Node(5, null, null);

        IsThisBinarySearchTree.Node nodeLayer1_0 = tree.new Node(5, nodeLayer2_0, nodeLayer2_1);
        IsThisBinarySearchTree.Node nodeLayer1_1 = tree.new Node(6, nodeLayer2_2, nodeLayer2_3);

        root = tree.new Node(4, nodeLayer1_0, nodeLayer1_1);

        assertFalse(tree.checkBST(root));
    }

    @Test
    public void testCheckBST_testCase1() {
        IsThisBinarySearchTree.Node nodeLayer2_0 = tree.new Node(1, null, null);
        IsThisBinarySearchTree.Node nodeLayer2_1 = tree.new Node(8, null, null);
        IsThisBinarySearchTree.Node nodeLayer2_2 = tree.new Node(5, null, null);
        IsThisBinarySearchTree.Node nodeLayer2_3 = tree.new Node(7, null, null);

        IsThisBinarySearchTree.Node nodeLayer1_0 = tree.new Node(2, nodeLayer2_0, nodeLayer2_1);
        IsThisBinarySearchTree.Node nodeLayer1_1 = tree.new Node(6, nodeLayer2_2, nodeLayer2_3);

        root = tree.new Node(4, nodeLayer1_0, nodeLayer1_1);

        assertFalse(tree.checkBST(root));
    }
}
