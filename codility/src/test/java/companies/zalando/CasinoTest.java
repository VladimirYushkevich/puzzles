package companies.zalando;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CasinoTest {

    private Casino casino;

    @Before
    public void setUp() {
        casino = new Casino();
    }

    @Test
    public void shouldPass() {
        assertThat(casino.solution(8, 0), is(7));
        assertThat(casino.solution(18, 2), is(6));
        assertThat(casino.solution(10, 10), is(4));
    }
}
