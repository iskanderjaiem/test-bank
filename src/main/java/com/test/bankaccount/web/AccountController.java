package com.test.bankaccount.web;

import com.test.bankaccount.application.AccountService;
import com.test.bankaccount.domain.Transaction;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.*;

@RestController
@RequestMapping("/api")
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service){
        this.service = service;
    }

    @PostMapping("/deposit")
    public ResponseEntity<?> deposit(@RequestBody Map<String, Integer> data){
        service.deposit(data.get("amount"));
        return ResponseEntity.ok().build();
    }

    @PostMapping("/withdrawal")
    public ResponseEntity<?> withdraw(@RequestBody Map<String, Integer> data){
        service.withdraw(data.get("amount"));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/statement")
    public List<Transaction> statement(){
        return service.getStatement();
    }

    @GetMapping("/balance")
    public int balance(){
        return service.currentBalance();
    }
}
