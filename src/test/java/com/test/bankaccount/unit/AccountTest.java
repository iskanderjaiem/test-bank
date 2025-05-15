package com.test.bankaccount.unit;

import com.test.bankaccount.domain.Account;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    void test_deposit(){
        Account acc = new Account();
        acc.deposit(80);
        assertEquals(80, acc.getBalance());
    }

    @Test
    void test_withdrawal(){
        Account acc = new Account();
        acc.deposit(100);
        acc.withdraw(30);
        assertEquals(70, acc.getBalance());
    }
}
