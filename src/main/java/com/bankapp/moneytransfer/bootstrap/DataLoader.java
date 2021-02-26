package com.bankapp.moneytransfer.bootstrap;

import com.bankapp.moneytransfer.model.Account;
import com.bankapp.moneytransfer.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    public final AccountRepository accountRepository;

    public DataLoader(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //loadData();
    }

    private void loadData() {
        Account alice = new Account("Alice","password",999999.00);
        Account bob = new Account("Bob","password",888888.00);

        accountRepository.saveAll(List.of(alice,bob));

    }


}
