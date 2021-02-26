package com.bankapp.moneytransfer.controller;


import com.bankapp.moneytransfer.model.Account;
import com.bankapp.moneytransfer.model.Response;
import com.bankapp.moneytransfer.model.Transaction;
import com.bankapp.moneytransfer.services.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class AccountController {


    private final AccountService accountService;

    public AccountController( AccountService accountService) {
        this.accountService = accountService;
    }


    @PostMapping("/balance")
    public ResponseEntity<Double> login(@RequestBody Long id){
        Double balance = accountService.getAccountBalance(id);
        //System.out.println(account1.getBalance());
        return new ResponseEntity<>(balance, HttpStatus.OK);
    }

    @PostMapping(value = "/transfer")
    public ResponseEntity<Response> transferMoney(@RequestBody Transaction transaction){
        Response result = accountService.makeTransfer(transaction.getRecieverId(), transaction.getSenderId(),transaction.getAmount());

        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @PostMapping(value = "/register")
    public String registerUser(@RequestBody Account account){
        Account a = new Account(account.getusername(), account.getPassword(), 0.00);
        accountService.createAccount(a);
        return "{\"success\":1}";
    }

    @PostMapping(value = "/login")
    public Long loginResponseObject(@RequestBody Account account){
        Account account1 = accountService.getAccountLogin(account.getusername(), account.getPassword());
        return account1.getId();
    }



}
