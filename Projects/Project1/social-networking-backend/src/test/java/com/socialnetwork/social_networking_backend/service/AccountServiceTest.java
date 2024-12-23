package com.socialnetwork.social_networking_backend.service;

import com.socialnetwork.social_networking_backend.controller.AccountController;
import com.socialnetwork.social_networking_backend.model.Account;
import com.socialnetwork.social_networking_backend.repository.AccountRepository;
import org.hibernate.dialect.function.array.ArrayContainsUnnestFunction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AccountServiceTest {

    private AccountRepository accountRepository;
    private AccountService accountService;
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void SetUp() {
        accountRepository = mock(AccountRepository.class);
        passwordEncoder = mock(PasswordEncoder.class);
        accountService = new AccountService(accountRepository);
    }

    @Test
    void createAccountSuccess() {
        Account account = new Account("testuser", "password123");
        when(accountRepository.existsByUsername("testuser")).thenReturn(false);
        when(accountRepository.save(account)).thenReturn(account);

        Account savedAccount = accountService.createAccount(account);

        assertNotNull(savedAccount, "saved account should not be null");
        assertEquals("testuser", savedAccount.getUsername(), "Username should match the input");
        assertEquals("password123", savedAccount.getPassword(), "Password should match the input");

        verify(accountRepository, times(1)).existsByUsername("testuser");
        verify(accountRepository, times(1)).save(account);
    }

    @Test
    void createAccountUserExists() {
        Account account = new Account("testuser", "test");
        when(accountRepository.existsByUsername("testuser")).thenReturn(true);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> accountService.createAccount(account),
                "Expected an IllegalArgumentException to be thrown"
        );
        assertEquals("Username already exists.", exception.getMessage(), "Exception message should match.");
    }

    @Test
    void createAccountUsernameBlank() {
        Account account = new Account("", "test");

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> accountService.createAccount(account),
                "Expected an IllegalArgumentException to be thrown"
        );
        assertEquals("Username cannot be blank.", exception.getMessage(), "Exception message should match.");
    }

    @Test
    void createAccountPasswordBlank() {
        Account account = new Account("testuser", "");

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> accountService.createAccount(account),
                "Expected an IllegalArgumentException to be thrown"
        );
        assertEquals("Invalid password.", exception.getMessage(), "Exception message should match.");

    }

    @Test
    void createAccountPasswordShort() {
        Account account = new Account("testuser", "123");

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> accountService.createAccount(account),
                "Expected an IllegalArgumentException to be thrown"
        );
        assertEquals("Invalid password.", exception.getMessage(), "Exception message should match.");
    }


    @Test
    void loginUsernameBlank() {
    }

    @Test
    void loginUsernameWrong() {
    }

    @Test
    void loginPasswordBlank() {
    }

    @Test
    void loginPasswordWrong() {
    }

    @Test
    void loginUsernamePasswordWrong() {

    }

}