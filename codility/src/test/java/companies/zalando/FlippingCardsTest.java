package companies.zalando;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FlippingCardsTest {

    private FlippingCards flippingCards;

    @Before
    public void setUp() {
        flippingCards = new FlippingCards();
    }

    @Test
    public void shouldPass() {
        assertThat(flippingCards.solution(new int[]{1, 2, 3, 4}, new int[]{1, 3, 2, 3}), is(2));
        assertThat(flippingCards.solution(new int[]{3, 2, 1, 6, 5}, new int[]{4, 2, 1, 3, 3}), is(3));
        assertThat(flippingCards.solution(new int[]{1, 2}, new int[]{1, 2}), is(3));
    }
}
