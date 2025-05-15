package com.test.bankaccount.infrastructure;

import com.test.bankaccount.domain.Transaction;

import java.time.format.DateTimeFormatter;
import java.util.List;
public class ConsoleStatementPrinter {

    public void print(List<Transaction> transactions) {
        System.out.println("DATE       | AMOUNT | BALANCE");

        int balance = 0;
        for (Transaction t : transactions) {
            balance += t.amount();
            String date = t.date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            String line = String.format("%s | %d | %d", date, t.amount(), balance);
            System.out.println(line);
        }
    }
}
