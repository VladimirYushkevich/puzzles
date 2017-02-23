package freetests.lesson6;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TriangleTest {

    private Triangle triangle;

    @Before
    public void setUp() {
        triangle = new Triangle();
    }

    @Test
    public void testTriangle() {
        assertThat(triangle.solution(new int[]{10, 2, 5, 1, 8, 20}), is(1));
        assertThat(triangle.solution(new int[]{10, 50, 5, 1}), is(0));
        assertThat(triangle.solution(new int[]{10, 5, 8}), is(1));
        assertThat(triangle.solution(new int[]{5, 8, 10}), is(1));
        assertThat(triangle.solution(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE - 5, Integer.MAX_VALUE - 2}), is(1));
    }
}
