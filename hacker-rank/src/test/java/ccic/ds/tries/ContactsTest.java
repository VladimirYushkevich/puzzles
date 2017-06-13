package ccic.ds.tries;

import org.junit.Before;
import org.junit.Test;

import static ccic.ds.tries.Contacts.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ContactsTest {

    private Contacts.Node root;

    @Before
    public void setUp() throws Exception {
        root = new Contacts.Node();
        insert(root, "any");
        insert(root, "answer");
        insert(root, "a");
        insert(root, "by");
        insert(root, "bye");
    }

    @Test
    public void testInsert() throws Exception {
        assertTrue(root.children.get('a').isLeaf);
        assertFalse(root.children.get('a').children.get('n').isLeaf);
        assertTrue(root.children.get('a').children.get('n').children.get('y').isLeaf);
        assertFalse(root.children.get('a').children.get('n').children.get('s').isLeaf);
        assertFalse(root.children.get('a').children.get('n').children.get('s').children.get('w').isLeaf);
        assertFalse(root.children.get('a').children.get('n').children.get('s').children.get('w').children.get('e').isLeaf);
        assertTrue(root.children.get('a').children.get('n').children.get('s').children.get('w').children.get('e').children.get('r').isLeaf);

        assertFalse(root.children.get('b').isLeaf);
        assertTrue(root.children.get('b').children.get('y').isLeaf);
        assertTrue(root.children.get('b').children.get('y').children.get('e').isLeaf);
    }

    @Test
    public void testSearch() throws Exception {
        assertTrue(getLastChild(root, "a").isLeaf);
        assertTrue(getLastChild(root, "any").isLeaf);
        assertTrue(getLastChild(root, "answer").isLeaf);
        assertFalse(getLastChild(root, "an").isLeaf);
    }

    @Test
    public void testGetNumberOfPartialWords() throws Exception {
        root = new Contacts.Node();
        insert(root, "hack");
        insert(root, "hackerrank");

        assertFalse(root.children.get('h').isLeaf);
        assertFalse(root.children.get('h').children.get('a').isLeaf);
        assertFalse(root.children.get('h').children.get('a').children.get('c').isLeaf);
        assertTrue(root.children.get('h').children.get('a').children.get('c').children.get('k').isLeaf);
        assertFalse(root.children.get('h').children.get('a').children.get('c').children.get('k')
                .children.get('e').isLeaf);
        assertFalse(root.children.get('h').children.get('a').children.get('c').children.get('k')
                .children.get('e').children.get('r').isLeaf);
        assertFalse(root.children.get('h').children.get('a').children.get('c').children.get('k')
                .children.get('e').children.get('r').children.get('r').isLeaf);
        assertFalse(root.children.get('h').children.get('a').children.get('c').children.get('k')
                .children.get('e').children.get('r').children.get('r').children.get('a').isLeaf);
        assertFalse(root.children.get('h').children.get('a').children.get('c').children.get('k')
                .children.get('e').children.get('r').children.get('r').children.get('a').children.get('n').isLeaf);
        assertTrue(root.children.get('h').children.get('a').children.get('c').children.get('k')
                .children.get('e').children.get('r').children.get('r').children.get('a').children.get('n').children.get('k').isLeaf);

        assertThat(getNumberOfPartialWords(root, "hac"), is(2));
        assertThat(getNumberOfPartialWords(root, "hack"), is(2));
        assertThat(getNumberOfPartialWords(root, "hacke"), is(1));
        assertThat(getNumberOfPartialWords(root, "hak"), is(0));
    }
}
