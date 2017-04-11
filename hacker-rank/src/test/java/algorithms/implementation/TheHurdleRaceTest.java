package algorithms.implementation;

import org.junit.Test;

import static algorithms.implementation.DesignerPDFViewer.getWordSquare;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TheHurdleRaceTest {

    @Test
    public void testGetNumberOfBeverages() throws Exception {
        assertThat(getWordSquare("abc", new int[]{1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}), is(9));
    }
}
