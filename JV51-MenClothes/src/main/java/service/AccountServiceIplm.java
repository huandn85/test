package service;

import entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AccountRepository;

import java.util.List;

@Service(value = "accountService")
public class AccountServiceIplm implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> getAll() {
        return (List<Account>)accountRepository.findAll();
    }
}
