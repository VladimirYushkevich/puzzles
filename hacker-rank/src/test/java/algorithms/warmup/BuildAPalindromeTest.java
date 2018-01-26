package algorithms.warmup;

import commons.BaseTest;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static algorithms.warmup.BuildAPalindrome.solution;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertArrayEquals;

public class BuildAPalindromeTest extends BaseTest {

    @Test
    public void buildAPalindromeTest() {
//        assertThat(solution("zban", "anat"), is("anana"));
//        assertThat(solution("cban", "anad"), is("anana"));
//        assertThat(solution("uuvepr", "riyfwsts"), is("rr"));
//        assertThat(solution("xabcy", "zcbat"), is("abcycba"));
        assertThat(solution("qquhuwqhdswxxrxuzzfhkplwunfagppcoildagktgdarveusjuqfistulgbglwmfgzrnyxryetwzhlnfewczmnoozlqatugmd",
                "jwgzcfabbkoxyjxkatjmpprswkdkobdagwdwxsufeesrvncbszcepigpbzuzoootorzfskcwbqorvw "), is("oozlzoo"));
    }

    @Test
    public void testManacher() {
        assertArrayEquals(new int[]{5, 3, 1, 3, 1, 1}, new BuildAPalindrome.Manacher("anonan").pal);
        assertArrayEquals(new int[]{5, 3, 3, 1, 1}, new BuildAPalindrome.Manacher("anana").pal);
        assertArrayEquals(new int[]{1, 3, 1, 1}, new BuildAPalindrome.Manacher("tana").pal);
        assertArrayEquals(new int[]{2, 1, 1}, new BuildAPalindrome.Manacher("kkb").pal);
        assertArrayEquals(new int[]{3, 2, 1, 1}, new BuildAPalindrome.Manacher("kkkb").pal);
        assertArrayEquals(new int[]{4, 3, 2, 1, 1}, new BuildAPalindrome.Manacher("kkkkb").pal);
        assertArrayEquals(new int[]{5, 4, 3, 2, 1, 1}, new BuildAPalindrome.Manacher("kkkkkb").pal);
        assertArrayEquals(new int[]{2, 1, 1, 1, 1, 1}, new BuildAPalindrome.Manacher("uuvepr").pal);
        assertArrayEquals(new int[]{3, 1, 1, 1, 1, 1, 1, 1}, new BuildAPalindrome.Manacher("stswfyir").pal);
    }

    @Test
    public void test() throws Exception {
        runTestCase(1);
        runTestCase(2);
        runTestCase(3);
        runTestCase(4);
        runTestCase(5);
        runTestCase(7);
        runTestCase(9);
        runTestCase(13);
        runTestCase(17);
        runTestCase(18);
        runTestCase(22);
    }

    private void runTestCase(int id) throws IOException {
        List<String> inputs = getParameters(getFile("input", id));
        List<String> outputs = getParameters(getFile("output", id));

        long start = System.currentTimeMillis();

        Integer numberOfPairs = Integer.valueOf(inputs.get(0));
        int pairIndex = 1;
        for (int i = 0; i < numberOfPairs; i++) {
            assertThat(solution(inputs.get(pairIndex), inputs.get(pairIndex + 1)), is(outputs.get(i)));
            pairIndex = pairIndex + 2;
        }

        System.out.println(String.format("Test Case [%s] finished after [%s] s", id,
                (System.currentTimeMillis() - start) / 1000.0d));
    }

    @Override
    protected List<String> getParameters(File file) throws IOException {
        List<String> inputs = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();
            inputs.add(line);

            while (line != null) {
                line = br.readLine();
                inputs.add(line);
            }
        }

        return inputs;
    }
}
