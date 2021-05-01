package companies.token;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CountingAnalogousArraysTest {

    @Test
    public void testCountAnalogousArrays() {
        assertThat(CountingAnalogousArrays.countAnalogousArrays(List.of(-2, -1, -2, 5), 3, 10), is(3));
        assertThat(CountingAnalogousArrays.countAnalogousArrays(List.of(-1, -3, 2), 2, 8), is(3));
        assertThat(CountingAnalogousArrays.countAnalogousArrays(List.of(1, 3, 2), 2, 8), is(1));
        assertThat(CountingAnalogousArrays.countAnalogousArrays(List.of(1, 2), 3, 4), is(0));
        assertThat(CountingAnalogousArrays.countAnalogousArrays(List.of(1, 3, 2), -2, 7), is(4));
    }

    @Test
    public void testFromFiles() throws IOException {
        assertThat(getResultFromFile("token/count_analogous_arrays/input002.txt"), is(202));
        assertThat(getResultFromFile("token/count_analogous_arrays/input003.txt"), is(1569));
        assertThat(getResultFromFile("token/count_analogous_arrays/input006.txt"), is(50003));
    }

    private int getResultFromFile(String path) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(getFile(path)));

        int consecutiveDifferenceCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> consecutiveDifference = IntStream.range(0, consecutiveDifferenceCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int lowerBound = Integer.parseInt(bufferedReader.readLine().trim());

        int upperBound = Integer.parseInt(bufferedReader.readLine().trim());

        bufferedReader.close();

        return CountingAnalogousArrays.countAnalogousArrays(consecutiveDifference, lowerBound, upperBound);
    }

    private File getFile(String path) {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(path);
        assert resource != null;
        return new File(resource.getPath());
    }
}
