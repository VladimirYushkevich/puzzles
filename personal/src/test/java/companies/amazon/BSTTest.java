package companies.amazon;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 *              5     layer 0
 *            /  \
 *           /   \
 *          3    6    layer 1
 *        /  \
 *       /   \
 *      1    4        layer 2
 *       \
 *       \
 *       2            layer 3
 */
public class BSTTest {

    private BST bst;

    @Before
    public void setUp() throws Exception {
        bst = new BST();
    }

    @Test
    public void testBst() throws Exception {
       assertThat(bst.bstDistance(new int[]{5, 6, 3, 1, 2, 4}, 6, 2, 4), is(3));
       assertThat(bst.bstDistance(new int[]{5, 6, 3, 1, 2, 4}, 6, 1, 4), is(2));
       assertThat(bst.bstDistance(new int[]{5, 6, 3, 1, 2, 4}, 6, 4, 2), is(3));
       assertThat(bst.bstDistance(new int[]{5, 6, 3, 1, 2, 4}, 6, 2, 6), is(4));
       assertThat(bst.bstDistance(new int[]{5, 6, 3, 1, 2, 4}, 6, 4, 6), is(3));
       assertThat(bst.bstDistance(new int[]{5, 6, 3, 1, 2, 4}, 6, 3, 6), is(2));
       assertThat(bst.bstDistance(new int[]{5, 6, 3, 1, 2, 4}, 6, 3, 8), is(-1));
       assertThat(bst.bstDistance(new int[]{5, 6, 3, 1, 2, 4}, 6, 8, 6), is(-1));
    }
}
