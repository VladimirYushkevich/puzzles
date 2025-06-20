package companies.finleap;

import org.junit.Before;
import org.junit.Test;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class BookTest {

    private Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @Test
    public void testBook() {
        List<Chapter> chapters = Arrays.asList(
                new Chapter("chapter title1", 5),
                new Chapter("chapter title2", 10)
        );
        List<String> authors = Arrays.asList("1", "2", "3");

        Book book = new Book(
                "title",
                chapters,
                authors,
                "9780804429573",
                LocalDate.now().minus(Period.ofDays(15)),
                LocalDate.now(),
                15
        );

        Set<ConstraintViolation<Object>> constraintViolations = validator
                .validate(book);
        constraintViolations.forEach(System.out::println);
        assertTrue(constraintViolations.isEmpty());
    }
}
