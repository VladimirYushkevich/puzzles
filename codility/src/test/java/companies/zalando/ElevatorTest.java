package companies.zalando;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ElevatorTest {

    private Elevator elevator;

    @Before
    public void setUp() {
        elevator = new Elevator();
    }

    @Test
    public void testElevator() {
        assertThat(elevator.solution(new int[]{60, 80, 40}, new int[]{2, 3, 5}, 5, 2, 200), is(5));
        assertThat(elevator.solution(new int[]{40, 40, 100, 80, 20}, new int[]{3, 3, 2, 2, 3}, 3, 5, 200), is(6));
    }
}
