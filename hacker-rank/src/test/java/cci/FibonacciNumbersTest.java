package cci;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FibonacciNumbersTest {

    @Test
    public void fibonacciNumbers() {
        assertThat(FibonacciNumbers.fibonacci(3), is(2));
        assertThat(FibonacciNumbers.fibonacci(4), is(3));
        assertThat(FibonacciNumbers.fibonacci(5), is(5));
        assertThat(FibonacciNumbers.fibonacci(6), is(8));
    }
}
