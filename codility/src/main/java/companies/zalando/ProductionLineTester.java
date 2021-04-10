package companies.zalando;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

public class ProductionLineTester {

    private final ProductVerifier verifier;

    ProductionLineTester(ProductVerifier verifier) {
        this.verifier = verifier;
    }

    ProductLineTestReport isValid(Stream<Product> products) {
        if (products == null) return new ProductLineTestReport(0,0,0,0);

        final int numberToIgnore = 1;
        final int numberToProcess = 2;
        final AtomicLong correctCnt = new AtomicLong(0);
        final AtomicLong checkedExcCnt = new AtomicLong(0);
        final AtomicLong uncheckedExcCnt = new AtomicLong(0);
        final AtomicLong otherExcCnt = new AtomicLong(0);

        products
                .filter(Objects::nonNull)
                .filter(ProductionLineTester::isValid)
                .skip(numberToIgnore)
                .limit(numberToProcess)
                .forEach(p -> verifySafely(p, correctCnt, checkedExcCnt, uncheckedExcCnt, otherExcCnt));

        return new ProductLineTestReport(
                correctCnt.get(),
                checkedExcCnt.get(),
                uncheckedExcCnt.get(),
                otherExcCnt.get()
        );
    }

    private static boolean isValid(Product p) {
        return !"invalid".equalsIgnoreCase(p.getStatus());
    }

    private void verifySafely(
            Product product,
            AtomicLong correctCnt,
            AtomicLong checkedExcCnt,
            AtomicLong uncheckedExcCnt,
            AtomicLong otherExcCnt
    ) {
        try {
            verifier.verify(product);
            correctCnt.incrementAndGet();
        } catch (Error err) {
            otherExcCnt.incrementAndGet();
        } catch (RuntimeException ex) {
            uncheckedExcCnt.incrementAndGet();
        } catch (Exception ex) {
            checkedExcCnt.incrementAndGet();
        }
    }

    static class ProductLineTestReport {

        long correctCnt;      // number of correct products
        long checkedExcCnt;   // number of products which threw a checked exception during verification
        long uncheckedExcCnt; // number of products which threw an unchecked exception during verification
        long otherExcCnt;     // number of products which threw an error during verification

        ProductLineTestReport(long correctCnt, long checkedExcCnt, long uncheckedExcCnt, long otherExcCnt) {
            this.correctCnt = correctCnt;
            this.checkedExcCnt = checkedExcCnt;
            this.uncheckedExcCnt = uncheckedExcCnt;
            this.otherExcCnt = otherExcCnt;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ProductLineTestReport that = (ProductLineTestReport) o;
            return correctCnt == that.correctCnt &&
                    checkedExcCnt == that.checkedExcCnt &&
                    uncheckedExcCnt == that.uncheckedExcCnt &&
                    otherExcCnt == that.otherExcCnt;
        }

        @Override
        public int hashCode() {
            return Objects.hash(correctCnt, checkedExcCnt, uncheckedExcCnt, otherExcCnt);
        }
    }

    static class Product {
        String status;

        public Product(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Product product = (Product) o;
            return Objects.equals(status, product.status);
        }

        @Override
        public int hashCode() {
            return Objects.hash(status);
        }
    }

    interface ProductVerifier {
        void verify(Product product) throws Exception;
    }
}
