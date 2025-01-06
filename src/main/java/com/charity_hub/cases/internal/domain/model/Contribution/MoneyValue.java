package com.charity_hub.cases.internal.domain.model.Contribution;

import com.charity_hub.cases.internal.domain.exceptions.InvalidAmountException;

public record MoneyValue(int value) {

    public MoneyValue {
        if (value < 0) {
            throw new InvalidAmountException(value);
        }
    }

    public static MoneyValue of(int value) {
        return new MoneyValue(value);
    }

    public MoneyValue plus(MoneyValue increment) {
        return new MoneyValue(this.value + increment.value());
    }

    public MoneyValue minus(MoneyValue decrement) {
        return new MoneyValue(this.value - decrement.value());
    }

}