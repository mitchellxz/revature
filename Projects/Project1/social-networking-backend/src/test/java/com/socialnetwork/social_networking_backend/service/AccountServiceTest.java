package com.socialnetwork.social_networking_backend.service;

import com.socialnetwork.social_networking_backend.model.Account;
import com.socialnetwork.social_networking_backend.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AccountServiceTest {

    @InjectMocks
    private AccountService accountService;

    @Mock
    private AccountRepository accountRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createAccount_ValidAccount_ReturnsSavedAccount() {
        Account account = new Account(null, "testuser", "password");
        when(accountRepository.existsByUsername("testuser")).thenReturn(false);
        when(accountRepository.save(account)).thenReturn(new Account(1L, "testuser", "password"));

        Account result = accountService.createAccount(account);

        assertNotNull(result);
        assertEquals("testuser", result.getUsername());
        verify(accountRepository, times(1)).existsByUsername("testuser");
        verify(accountRepository, times(1)).save(account);
    }

    @Test
    void createAccount_UsernameExists_ThrowsException() {
        Account account = new Account(null, "testuser", "password");
        when(accountRepository.existsByUsername("testuser")).thenReturn(true);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            accountService.createAccount(account);
        });
        assertEquals("Username already exists.", exception.getMessage());
        verify(accountRepository, times(1)).existsByUsername("testuser");
        verify(accountRepository, times(0)).save(account);
    }

    @Test
    void createAccount_InvalidPassword_ThrowsException() {
        Account account = new Account(null, "testuser", "123");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            accountService.createAccount(account);
        });
        assertEquals("Invalid password.", exception.getMessage());
        verify(accountRepository, times(0)).save(account);
    }

    @Test
    void loadUserByUsername_ValidUsername_ReturnsUserDetails() {
        Account account = new Account(1L, "testuser", "password");
        when(accountRepository.findByUsername("testuser")).thenReturn(Optional.of(account));

        UserDetails userDetails = accountService.loadUserByUsername("testuser");

        assertNotNull(userDetails);
        assertEquals("testuser", userDetails.getUsername());
        verify(accountRepository, times(1)).findByUsername("testuser");
    }

    @Test
    void loadUserByUsername_InvalidUsername_ThrowsException() {
        when(accountRepository.findByUsername("nonexistentuser")).thenReturn(Optional.empty());

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            accountService.loadUserByUsername("nonexistentuser");
        });
        assertEquals("Invalid Credentials.", exception.getMessage());
        verify(accountRepository, times(1)).findByUsername("nonexistentuser");
    }

    @Test
    void getAllAccounts_ReturnsListOfAccounts() {
        List<Account> accounts = Arrays.asList(
                new Account(1L, "user1", "password1"),
                new Account(2L, "user2", "password2")
        );
        when(accountRepository.findAll()).thenReturn(accounts);

        List<Account> result = accountService.getAllAccounts();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("user1", result.get(0).getUsername());
        assertEquals("user2", result.get(1).getUsername());
        verify(accountRepository, times(1)).findAll();
    }
}
