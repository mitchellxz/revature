package com.socialnetwork.social_networking_backend.service;

import com.socialnetwork.social_networking_backend.exception.InvalidAccountException;
import com.socialnetwork.social_networking_backend.exception.UsernameExistsException;
import com.socialnetwork.social_networking_backend.model.Account;
import com.socialnetwork.social_networking_backend.model.Profile;
import com.socialnetwork.social_networking_backend.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements UserDetailsService {
    private final AccountRepository accountRepository;
    
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(Account account) {
        if (account.getUsername() == null|| account.getUsername().isBlank()) {
            throw new IllegalArgumentException("Username cannot be blank.");
        }
        if (account.getPassword() == null || account.getPassword().length() < 4) {
            throw new IllegalArgumentException("Invalid password.");
        }
        if (accountRepository.existsByUsername(account.getUsername())) {
            throw new IllegalArgumentException("Username already exists.");
        }
        return accountRepository.save(account);
    }

    public UserDetails loadUserByUsername(String username) {
        return accountRepository.findByUsername(username)
                .map(user -> User.builder()
                        .username(user.getUsername())
                        .password(user.getPassword())
                        .build())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Credentials."));
        }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
}
