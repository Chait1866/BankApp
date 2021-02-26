package com.bankapp.moneytransfer.services;

import com.bankapp.moneytransfer.model.Account;
import com.bankapp.moneytransfer.model.Response;
import com.bankapp.moneytransfer.repository.AccountRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Double getAccountBalance(Long id) {
        return this.accountRepository.findById(id).get().getBalance();
    }

    @Override
    public Account getAccountLogin(String username, String password) {
        return this.accountRepository.findAccountByUsernameAndPassword(username,password);
    }

    @Override
    public Response makeTransfer(Long recieverId, Long senderId, Double Amount) {
        Optional<Account> reciever = accountRepository.findById(recieverId);
        reciever.get().setBalance(getAccountBalance(recieverId)+Amount);
        accountRepository.save(reciever.get());
        Optional<Account> sender = accountRepository.findById(senderId);
        sender.get().setBalance(getAccountBalance(senderId)-Amount);
        accountRepository.save(sender.get());
        return new Response(sender.get().getBalance(),sender.get().getusername(), reciever.get().getBalance(),reciever.get().getusername());

//        String result  = "Receiver "+reciever.get().getusername()+" Balance is "+reciever.get().getBalance() + "\n" + " Sender "+
//        sender.get().getusername()+" Balance is "+sender.get().getBalance();
//        return result;
    }

    @Override
    public void createAccount(Account a) {
        accountRepository.save(a);

    }

}
