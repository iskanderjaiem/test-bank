package com.test.bankaccount.unit;

import com.test.bankaccount.domain.Transaction;
import com.test.bankaccount.infrastructure.ConsoleStatementPrinter;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class ConsoleStatementPrinterTest {

    @Test
    public void should_print_statement_to_console() {
        // given
        List<Transaction> transactions = List.of(
                new Transaction(LocalDate.of(2025, 1, 1), 100),
                new Transaction(LocalDate.of(2025, 1, 2), -30)
        );

        ConsoleStatementPrinter printer = new ConsoleStatementPrinter();

        // redirect System.out
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // when
        printer.print(transactions);

        // then
        String printed = out.toString();
        assertTrue(printed.contains("DATE       | AMOUNT | BALANCE"));
        assertTrue(printed.contains("01/01/2025 | 100 | 100"));
        assertTrue(printed.contains("02/01/2025 | -30 | 70"));
    }
}