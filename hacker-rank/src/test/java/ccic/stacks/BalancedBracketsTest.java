package ccic.stacks;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BalancedBracketsTest {

    @Test
    public void testBalancedBrackets() throws Exception {
        assertTrue(BalancedBrackets.isBalanced("{[()]}"));
        assertFalse(BalancedBrackets.isBalanced("{[(])}"));
        assertTrue(BalancedBrackets.isBalanced("{{[[(())]]}}"));
        assertFalse(BalancedBrackets.isBalanced("{"));
        assertFalse(BalancedBrackets.isBalanced("{]"));
        assertFalse(BalancedBrackets.isBalanced("{[]"));
        assertFalse(BalancedBrackets.isBalanced("{[()}}"));
    }
}
