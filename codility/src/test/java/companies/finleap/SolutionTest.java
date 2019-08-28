package companies.finleap;

import org.junit.Test;

import static companies.finleap.Solution.solution;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SolutionTest {

    @Test
    public void testSolution() {
        assertThat(solution("John Doe; Peter Parker; Mary Jane Watson-Parker; James Doe; John Elvis Doe; Jane Doe; " +
                        "Penny Parker",
                "Example"),
                is("j_doe@example.com; p_parker@example.com; m_watsonparker@example.com; " +
                        "j_doe2@example.com; j_doe3@example.com; j_doe4@example.com; p_parker2@example.com"));
    }
}
