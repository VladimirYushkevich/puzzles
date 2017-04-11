package algorithms.implementation;

import org.junit.Test;

import static algorithms.implementation.OrganizingContainersOfBalls.checkQuery;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class OrganizingContainersOfBallsTests {

    @Test
    public void testCheckQuery() throws Exception {
        assertThat(checkQuery(new int[][]{{1, 0}, {0, 1}}, 2), is("Possible"));
        assertThat(checkQuery(new int[][]{{1, 2}, {2, 1}}, 2), is("Possible"));
        assertThat(checkQuery(new int[][]{{0, 4, 0}, {2, 0, 1}, {1, 0, 2}}, 3), is("Possible"));
        assertThat(checkQuery(new int[][]{{0, 2}, {1, 1}}, 2), is("Impossible"));
    }
}
