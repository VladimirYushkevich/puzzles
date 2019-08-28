package companies.finleap;

import org.hibernate.validator.constraints.ISBN;

import javax.validation.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.LocalDate;
import java.util.List;

@ValidBook
public class Book {
    @NotEmpty
    private String title;
    @Valid
    @NotEmpty
    private List<Chapter> chapters;
    @NotNull
    @Size(min = 1, max = 3)
    private List<String> authors;
    @ISBN
    private String isbn;
    @NotNull
    private LocalDate firstEditionPublishDate;
    @NotNull
    private LocalDate lastEditionPublishDate;
    @NotNull
    private Integer numberOfPages;

    Book(String title,
         List<Chapter> chapters,
         List<String> authors,
         String isbn,
         LocalDate firstEditionPublishDate,
         LocalDate lastEditionPublishDate,
         Integer numberOfPages) {
        this.title = title;
        this.chapters = chapters;
        this.authors = authors;
        this.isbn = isbn;
        this.firstEditionPublishDate = firstEditionPublishDate;
        this.lastEditionPublishDate = lastEditionPublishDate;
        this.numberOfPages = numberOfPages;
    }

    String getTitle() {
        return title;
    }

    List<Chapter> getChapters() {
        return chapters;
    }

    List<String> getAuthors() {
        return authors;
    }

    String getIsbn() {
        return isbn;
    }

    LocalDate getFirstEditionPublishDate() {
        return firstEditionPublishDate;
    }

    LocalDate getLastEditionPublishDate() {
        return lastEditionPublishDate;
    }

    Integer getNumberOfPages() {
        return numberOfPages;
    }

    public static class BookValidator implements ConstraintValidator<ValidBook, Book> {

        @Override
        public void initialize(ValidBook constraintAnnotation) {
        }

        @Override
        public boolean isValid(Book value, ConstraintValidatorContext context) {
            final LocalDate firstEditionPublishDate = value.getFirstEditionPublishDate();
            final LocalDate lastEditionPublishDate = value.getLastEditionPublishDate();
            final Integer numberOfPages = value.getNumberOfPages();
            final List<String> authors = value.getAuthors();
            final List<Chapter> chapters = value.getChapters();
            if (firstEditionPublishDate == null
                    || lastEditionPublishDate == null
                    || numberOfPages == null
                    || authors == null
                    || chapters == null
            ) {
                System.out.println("Something is invalid");
                return false;
            }
            final int sumOfChapterPages = chapters.stream().mapToInt(Chapter::getNumberOfPages).sum();
            return firstEditionPublishDate.isBefore(lastEditionPublishDate)
                    && numberOfPages == sumOfChapterPages
                    && !authors.contains(null);
        }
    }
}

@Constraint(validatedBy = Book.BookValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface ValidBook {
    String message() default "{validation.date.BookDateConstraint.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

class Chapter {
    @NotNull
    private String title;
    @Min(1)
    private Integer numberOfPages;

    Chapter(String title, Integer numberOfPages) {
        this.title = title;
        this.numberOfPages = numberOfPages;
    }

    public String toString() {
        return "Chapter{" +
                "title='" + title + '\'' +
                ", numberOfPages=" + numberOfPages +
                '}';
    }

    String getTitle() {
        return title;
    }

    Integer getNumberOfPages() {
        return numberOfPages;
    }
}
