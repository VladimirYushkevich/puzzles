package cci;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class PlayerComparatorTest {

    @Test
    public void playerComparator() {
        List<PlayerComparator.Player> input = Arrays.asList(
                new PlayerComparator.Player("amy", 100),
                new PlayerComparator.Player("david", 100),
                new PlayerComparator.Player("heraldo", 50),
                new PlayerComparator.Player("aakansha", 75),
                new PlayerComparator.Player("aleksa", 150)
        );
        List<PlayerComparator.Player> output = Arrays.asList(
                new PlayerComparator.Player("aleksa", 150),
                new PlayerComparator.Player("amy", 100),
                new PlayerComparator.Player("david", 100),
                new PlayerComparator.Player("aakansha", 75),
                new PlayerComparator.Player("heraldo", 50)
        );
        Collections.sort(input, new PlayerComparator.Checker());
        assertArrayEquals(input.toArray(), output.toArray());
    }
}
