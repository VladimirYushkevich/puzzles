package companies.zalando;

import org.junit.Test;

import java.io.IOException;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

public class ProductionLineTesterTest {

    private ProductionLineTester solution;
    private ProductionLineTester.ProductVerifier verifier;

    @Test
    public void testSolution() {
        verifier = mock(ProductionLineTester.ProductVerifier.class);

        solution = new ProductionLineTester(verifier);

        assertThat(solution.isValid(Stream.of(
                new ProductionLineTester.Product("aaa"),
                new ProductionLineTester.Product("bbb"),
                new ProductionLineTester.Product("ccc"),
                new ProductionLineTester.Product("ddd")
        )), is(new ProductionLineTester.ProductLineTestReport(2, 0, 0, 0)));
    }

    @Test
    public void testSolutionException() throws Exception {
        verifier = mock(ProductionLineTester.ProductVerifier.class);
        doThrow(new IOException()).when(verifier).verify(new ProductionLineTester.Product("bbb"));

        solution = new ProductionLineTester(verifier);

        assertThat(solution.isValid(Stream.of(
                new ProductionLineTester.Product("aaa"),
                new ProductionLineTester.Product("bbb"),
                new ProductionLineTester.Product("ccc"),
                new ProductionLineTester.Product("ddd")
        )), is(new ProductionLineTester.ProductLineTestReport(1, 1, 0, 0)));
    }

    @Test
    public void testSolutionRuntimeException() throws Exception {
        verifier = mock(ProductionLineTester.ProductVerifier.class);
        doThrow(new RuntimeException()).when(verifier).verify(new ProductionLineTester.Product("bbb"));

        solution = new ProductionLineTester(verifier);

        assertThat(solution.isValid(Stream.of(
                new ProductionLineTester.Product("aaa"),
                new ProductionLineTester.Product("bbb"),
                new ProductionLineTester.Product("ccc"),
                new ProductionLineTester.Product("ddd")
        )), is(new ProductionLineTester.ProductLineTestReport(1, 0, 1, 0)));
    }

    @Test
    public void testSolutionFilterNull() {
        verifier = mock(ProductionLineTester.ProductVerifier.class);

        solution = new ProductionLineTester(verifier);

        assertThat(solution.isValid(Stream.of(
                new ProductionLineTester.Product("aaa"),
                null,
                null,
                new ProductionLineTester.Product("ddd")
        )), is(new ProductionLineTester.ProductLineTestReport(1, 0, 0, 0)));
    }

    @Test
    public void testSolutionFilterInvalid() {
        verifier = mock(ProductionLineTester.ProductVerifier.class);

        solution = new ProductionLineTester(verifier);

        assertThat(solution.isValid(Stream.of(
                new ProductionLineTester.Product("aaa"),
                new ProductionLineTester.Product("invalid"),
                new ProductionLineTester.Product("INVALID")
        )), is(new ProductionLineTester.ProductLineTestReport(0, 0, 0, 0)));
    }
}
