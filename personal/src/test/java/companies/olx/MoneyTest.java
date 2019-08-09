package companies.olx;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MoneyTest {

    @Test
    public void should_chain_money_values_for_same_currencies_when_they_are_the_same() {
        var money = new Money(1.0, "USD");
        var moneyToAdd = new Money(2.0, "USD");

        var added = money.add(moneyToAdd);
        assertThat(added, is(new Money(3.0, "USD")));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_for_different_currencies() {
        var money = new Money(1.0, "USD");
        var moneyToAdd = new Money(2.0, "EUR");

        money.add(moneyToAdd);
    }

    @Test
    public void should_add_a_fee_to_the_list_of_moneys() {
        var moneys = List.of(new Money(1.0, "USD"), new Money(2.0, "USD"));
        var fee = 3.0;

        assertThat(Money.addFee(moneys, fee), is(List.of(new Money(4.0, "USD"), new Money(5.0, "USD"))));
    }

    @Test
    public void should_throw_exception_for_different_currencies_by_adding_fee() {
        var moneys = List.of(new Money(1.0, "USD"), new Money(2.0, "EUR"));
        var fee = 3.0;

        assertThat(Money.addFee(moneys, fee), is(List.of(new Money(4.0, "USD"), new Money(5.0, "EUR"))));
    }
}
