package com.test.bankaccount.domain;

import java.util.List;
import java.util.ArrayList;

public class Account {

    private List<Transaction> operations = new ArrayList<>();

    public void deposit(int amount){
        if(amount <= 0){
            throw new IllegalArgumentException("Amount must be positive");
        }
        operations.add(Transaction.deposit(amount));
    }

    public void deposit(int amount, java.time.LocalDate date){
        if(amount <= 0){
            throw new IllegalArgumentException("Amount must be positive");
        }
        operations.add(Transaction.deposit(amount, date));
    }

    public void withdraw(int amount){
        if(amount <= 0){
            throw new IllegalArgumentException("Amount must be positive");
        }
        operations.add(Transaction.withdraw(amount));
    }

    public void withdraw(int amount, java.time.LocalDate date){
        if(amount <= 0){
            throw new IllegalArgumentException("Amount must be positive");
        }
        operations.add(Transaction.withdraw(amount, date));
    }

    public int getBalance(){
        return operations.stream().mapToInt(Transaction::amount).sum();
    }

    public List<Transaction> getOperations(){
        return operations;
    }
}
