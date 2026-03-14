package domain;

import exceptions.MoneyCreationException;
import exceptions.MoneySettingException;

import java.util.Objects;

public class Money {
    private double amount;

    public Money(double amount) {
        if (amount < 0) {
            throw new MoneyCreationException("Money cannot be negative");
        }

        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        if (amount < 0) {
            throw new MoneySettingException("Money cannot be set tp  negative");
        }

        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(amount);
    }

    @Override
    public String toString() {
        return amount + " $";
    }
}
