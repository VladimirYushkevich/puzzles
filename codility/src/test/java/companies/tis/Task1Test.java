package companies.tis;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task1Test {

    private Task1 task = new Task1();

    @Test
    public void testSolution() {
        assertEquals(5, task.solution("azABaabza"));
    }
}
