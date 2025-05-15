package com.test.bankaccount.cucumber.stepdefs;

import com.test.bankaccount.application.AccountService;
import io.cucumber.java.en.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.StringWriter;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.time.LocalDate;

public class BankAccountStepDefs {

    private AccountService service;
    private int actual;
    private StringWriter output;

    @Given("I have an empty bank account")
    public void init_account(){
        service = new AccountService();
    }

    @Given("I have a bank account with {int} euros")
    public void i_have_a_bank_account_with_euros(Integer int1) {
        service = new AccountService();
        service.deposit(int1);
    }

    @Given("I made the following operations:")
    public void i_made_the_following_operations(io.cucumber.datatable.DataTable dataTable) {
        service = new AccountService();
        List<Map<String, String>> ops = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> op : ops) {
            String amountStr = op.get("amount");
            String dateStr = op.get("date");
            LocalDate date = LocalDate.parse(dateStr);
            int amount = Integer.parseInt(amountStr.replace("+", "").replaceAll("\s", ""));
            if (amount > 0) {
                service.deposit(amount, date);
            } else {
                service.withdraw(-amount, date); // withdraw expects positive value
            }
        }
    }

    @When("I deposit {int} euros")
    public void make_deposit(int amount){
        service.deposit(amount);
    }

    @When("I withdraw {int} euros")
    public void make_withdrawal(int amount){
        service.withdraw(amount);
    }

    @When("I request the statement")
    public void i_request_the_statement() {
        // Capture System.out
        output = new StringWriter();
        PrintWriter pw = new PrintWriter(output);
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(new OutputStream() {
            @Override public void write(int b) { pw.write(b); }
        }));
        try {
            new com.test.bankaccount.infrastructure.ConsoleStatementPrinter().print(service.getStatement());
        } finally {
            System.out.flush();
            System.setOut(originalOut);
            pw.flush();
        }
    }

    @Then("the account balance should be {int} euros")
    public void check_balance(int expected){
        actual = service.currentBalance();
        assertEquals(expected, actual);
    }

    @Then("the output should be:")
    public void the_output_should_be(String docString) {
        String actualOutput = output.toString().trim().replace("\r\n", "\n");
        String expectedOutput = docString.trim().replace("\r\n", "\n");

        String[] actualLines = actualOutput.split("\n");
        String[] expectedLines = expectedOutput.split("\n");
        assertEquals(expectedLines.length, actualLines.length, "Line count mismatch in statement output");
        for (int i = 0; i < actualLines.length; i++) {
            String actualNorm = actualLines[i].replaceAll("\\s+", " ").trim();
            String expectedNorm = expectedLines[i].replaceAll("\\s+", " ").trim();
            assertEquals(expectedNorm, actualNorm, "Difference at line " + (i+1));
        }
    }
}

