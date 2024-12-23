package com.socialnetwork.social_networking_backend.controller;

import com.socialnetwork.social_networking_backend.model.Account;
import com.socialnetwork.social_networking_backend.model.Profile;
import com.socialnetwork.social_networking_backend.service.AccountService;
import com.socialnetwork.social_networking_backend.service.ProfileService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class AccountController {
    private final AccountService accountService;
    private final ProfileService profileService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AccountController(AccountService accountService, ProfileService profileService) {
        this.accountService = accountService;
        this.profileService = profileService;
    }

    @PostMapping("/register")
    public Account createAccount(@RequestBody Account account) {
        Account newAccount = accountService.createAccount(account);
        account.setPassword(passwordEncoder.encode(account.getPassword()));

        Profile profile = new Profile(newAccount);
        profileService.createProfile(profile);

        return newAccount;
    }


    @PostMapping("/login")
    public ResponseEntity<UserDetails> loginUser(@RequestBody Account account) {
        UserDetails userDetails = accountService.loadUserByUsername(account.getUsername());

        if (passwordEncoder.matches(account.getPassword(), userDetails.getPassword())) {
            return ResponseEntity.ok(userDetails);
        }
        else {
            throw new IllegalArgumentException("Invalid Credentials");
        }
    }

    @GetMapping("/all")
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

}
