package com.socialnetwork.social_networking_backend.service;

import com.socialnetwork.social_networking_backend.exception.InvalidAccountException;
import com.socialnetwork.social_networking_backend.exception.UsernameExistsException;
import com.socialnetwork.social_networking_backend.model.Account;
import com.socialnetwork.social_networking_backend.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    public Account registerAccount(Account account) throws InvalidAccountException, UsernameExistsException {
        if (account.getUsername() == null || account.getUsername().isBlank()) {
            throw new InvalidAccountException("Invalid username.");
        }
        if (account.getPassword() == null || account.getPassword().length() < 4) {
            throw new InvalidAccountException("Invalid password.");
        }

        if (accountRepository.existsByUsername(account.getUsername())) {
            throw new UsernameExistsException("Username already exists.");
        }
        return accountRepository.save(account);
    }
}
