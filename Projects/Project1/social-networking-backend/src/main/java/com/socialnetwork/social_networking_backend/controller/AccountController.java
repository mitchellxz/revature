package com.socialnetwork.social_networking_backend.controller;

import com.socialnetwork.social_networking_backend.model.Account;
import com.socialnetwork.social_networking_backend.model.Profile;
import com.socialnetwork.social_networking_backend.service.AccountService;
import com.socialnetwork.social_networking_backend.service.ProfileService;
import jakarta.servlet.http.HttpSession;
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
import java.util.Objects;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class AccountController extends BaseController{
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
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody Account account, HttpSession session) {
        UserDetails userDetails = accountService.loadUserByUsername(account.getUsername());

        if (passwordEncoder.matches(account.getPassword(), userDetails.getPassword())) {
            session.setAttribute("username", account.getUsername());

            Map<String, String> response = new HashMap<>();
            response.put("message", "Login successsful");
            response.put("username", account.getUsername());

            return ResponseEntity.ok(response);
        }
        else {
            throw new IllegalArgumentException("Invalid Credentials");
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllAccounts() {
        if(!isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User is not authenticated");
        }
        List<Account> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logoutAccount(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok("Logged out successfully.");
    }

    @GetMapping("/currentuser")
    public ResponseEntity<Map<String, String>> getCurrentUser(HttpSession session) {
        String username = (String) session.getAttribute("username");

        if (username != null) {
            Map<String, String> response = new HashMap<>();
            response.put("username", username);
            return ResponseEntity.ok(response);
        }
        else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

}
