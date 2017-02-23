package freetests.lesson5;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class GenomicRangeQueryTest {

    private GenomicRangeQuery genomicRangeQuery;

    @Before
    public void setUp() {
        genomicRangeQuery = new GenomicRangeQuery();
    }

    @Test
    public void testGenomicRangeQuery() {
        assertArrayEquals(new int[]{2, 4, 1}, genomicRangeQuery.solution("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6}));
        assertArrayEquals(new int[]{2, 3, 4}, genomicRangeQuery.solution("CCGGTT", new int[]{0, 2, 4}, new int[]{1, 3, 5}));
    }
}
