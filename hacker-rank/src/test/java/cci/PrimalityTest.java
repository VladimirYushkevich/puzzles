package cci;

import org.junit.Test;

import java.util.Arrays;

import static cci.Primality.primality;
import static org.junit.Assert.assertArrayEquals;

public class PrimalityTest {

    @Test
    public void findPrimality() {
        assertArrayEquals(primality(Arrays.asList(12, 5, 7)).toArray(), Arrays.asList("Not prime", "Prime", "Prime").toArray());
        assertArrayEquals(primality(Arrays.asList(18, 9)).toArray(), Arrays.asList("Not prime", "Not prime").toArray());
        assertArrayEquals(primality(Arrays.asList(1000000007, 100000003, 1000003)).toArray(),
                Arrays.asList("Prime", "Not prime", "Prime").toArray());
    }
}
