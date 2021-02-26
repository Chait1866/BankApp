package com.bankapp.moneytransfer.repository;

import com.bankapp.moneytransfer.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


public interface AccountRepository extends JpaRepository<Account,Long> {

        Account findAccountByUsernameAndPassword(String username,String password);
        Account findAccountById(Long id);
}
