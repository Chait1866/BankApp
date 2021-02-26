package com.bankapp.moneytransfer.services;

import com.bankapp.moneytransfer.model.Account;
import com.bankapp.moneytransfer.model.Response;

public interface AccountService {

    Double getAccountBalance(Long id);
    Account getAccountLogin(String username, String password);
    Response makeTransfer(Long sender, Long receiver, Double Amount);
    void createAccount(Account a);

}
