package com.test.bankaccount.domain;

import java.time.LocalDate;

public record Transaction(LocalDate date, int amount) {

    public static Transaction deposit(int value){
        return new Transaction(LocalDate.now(), value);
    }

    public static Transaction deposit(int value, LocalDate date){
        return new Transaction(date, value);
    }

    public static Transaction withdraw(int value){
        return new Transaction(LocalDate.now(), -value);
    }

    public static Transaction withdraw(int value, LocalDate date){
        return new Transaction(date, -value);
    }
}
