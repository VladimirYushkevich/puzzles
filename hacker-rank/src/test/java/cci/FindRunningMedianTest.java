package cci;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

public class FindRunningMedianTest {

    private FindRunningMedian.BinaryHeap heap;

    @Before
    public void setUp() {
        heap = new FindRunningMedian.BinaryHeap(6);
    }

    @Test
    public void testAdd() {
        heap.add(12);
        assertThat(heap.items[0], is(12));

        assertThat(heap.getMedian(), is(12.0d));

        heap.add(4);
        assertThat(heap.items[0], is(4));
        assertThat(heap.items[1], is(12));

        assertThat(heap.getMedian(), is(8.0d));

        heap.add(5);
        assertThat(heap.items[0], is(4));
        assertThat(heap.items[1], is(5));
        assertThat(heap.items[2], is(12));

        assertThat(heap.getMedian(), is(5.0d));

        heap.add(3);
        assertThat(heap.items[0], is(3));
        assertThat(heap.items[1], is(4));
        assertThat(heap.items[2], is(5));
        assertThat(heap.items[3], is(12));

        assertThat(heap.getMedian(), is(4.5d));

        heap.add(8);
        heap.add(7);
        assertArrayEquals(heap.items, new int[]{3, 4, 5, 7, 8, 12});
    }
}
