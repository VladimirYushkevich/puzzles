package ccic;

import org.junit.Test;

import static ccic.ConnectedCellInAGrid.maxRegion;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ConnectedCellInAGridTest {

    @Test
    public void shouldCountMaxRegionSize() {
        assertThat(maxRegion(new int[][]{{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {1, 0, 0, 0}}, 4, 4),
                is(1));
        assertThat(maxRegion(new int[][]{{1, 1, 0, 0}, {0, 1, 1, 0}, {0, 0, 1, 0}, {1, 0, 0, 0}}, 4, 4),
                is(5));
        assertThat(maxRegion(new int[][]{{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}}, 4, 4),
                is(0));
        assertThat(maxRegion(new int[][]{{0, 0, 1, 1}, {0, 0, 1, 0}, {0, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}}, 5, 4),
                is(8));
        assertThat(maxRegion(new int[][]{{0, 1, 1, 1, 1}, {1, 0, 0, 0, 1}, {1, 1, 0, 1, 0}, {0, 1, 0, 1, 1},
                {0, 1, 1, 1, 0}}, 5, 5), is(15));
        assertThat(maxRegion(new int[][]{{1, 1, 1, 0, 1}, {0, 0, 1, 0, 0}, {1, 1, 0, 1, 0}, {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0}, {0, 1, 0, 0, 0}, {0, 0, 1, 1, 0}}, 7, 5), is(9));
    }
}
