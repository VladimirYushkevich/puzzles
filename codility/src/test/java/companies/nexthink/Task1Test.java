package companies.nexthink;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Task1Test {

    private final Task1 solution = new Task1();

    @Test
    public void testSolution() {
        Map<String, Task1.UserStats> one = new HashMap<>();
        one.put("1", new Task1.UserStats(2L));

        Map<String, Task1.UserStats> two = new HashMap<>();
        two.put("2", new Task1.UserStats(4L));
        two.put("3", null);
        two.put("a", new Task1.UserStats(4L));

        Map<String, Task1.UserStats> three = new HashMap<>();
        three.put("1", new Task1.UserStats(4L));
        three.put("2", new Task1.UserStats(3L));
        assertThat(solution.count(one, two, three), is(Map.of(1L, 6L, 2L, 7L)));
    }

    @Test
    public void testNullOnlyVisits() {
        Map<String, Task1.UserStats> one = new HashMap<>();
        one.put("3", null);
        one.put("4", null);
        assertThat(solution.count(one, null), is(new HashMap<>()));
    }
}
