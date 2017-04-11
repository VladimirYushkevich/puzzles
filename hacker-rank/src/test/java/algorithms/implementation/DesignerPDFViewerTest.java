package algorithms.implementation;

import org.junit.Test;

import static algorithms.implementation.TheHurdleRace.getNumberOfBeverages;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DesignerPDFViewerTest {

    @Test
    public void testGetWordSquare() throws Exception {
        assertThat(getNumberOfBeverages(new int[]{1, 6, 3, 5, 2}, 4), is(2));

    }
}
