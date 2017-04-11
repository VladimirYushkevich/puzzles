package algorithms.implementation;

import org.junit.Test;

import static algorithms.implementation.EqualizeArray.getMinNumberOfDeletion;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class EqualizeArrayTest {

    @Test
    public void testMinNumberOfDeletions() throws Exception {
        assertThat(getMinNumberOfDeletion(new int[]{3, 3, 2, 1, 3}, 5), is(2));
    }
}
