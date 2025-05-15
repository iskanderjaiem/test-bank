package com.test.bankaccount.application;

import com.test.bankaccount.domain.Account;
import com.test.bankaccount.domain.Transaction;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AccountService {

    private Account account = new Account();

    public void deposit(int amount){
        account.deposit(amount);
    }

    public void deposit(int amount, java.time.LocalDate date){
        account.deposit(amount, date);
    }

    public void withdraw(int amount){
        account.withdraw(amount);
    }

    public void withdraw(int amount, LocalDate date){
        account.withdraw(amount, date);
    }

    public List<Transaction> getStatement(){
        return account.getOperations();
    }

    public int currentBalance(){
        return account.getBalance();
    }
}
