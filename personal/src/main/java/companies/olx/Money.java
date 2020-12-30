package companies.olx;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Money {
    private final Double value;
    private final String name;

    public Money(Double value, String name) {
        this.value = value;
        this.name = name;
    }

    public static List<Money> addFee(List<Money> moneys, Double fee) {
        return moneys.stream()
                .map(m -> m.add(new Money(fee, m.getName())))
                .collect(Collectors.toList());
    }

    public Double getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    // not needed
    public Money copyOf() {
        return new Money(this.value, this.getName());
    }

    // A.add(B).add(C)
    public Money add(Money moneyToAdd) {
        if (!this.getName().equals(moneyToAdd.getName())) {
            throw new IllegalArgumentException("Moneys with different currencies can't be added");
        }
        return new Money(this.getValue() + moneyToAdd.getValue(), this.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return getValue().equals(money.getValue()) &&
                getName().equals(money.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue(), getName());
    }

    @Override
    public String toString() {
        return "Money{" +
                "value=" + value +
                ", name='" + name + '\'' +
                '}';
    }
}
