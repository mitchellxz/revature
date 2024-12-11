package com.socialnetwork.social_networking_backend.controller;

import com.socialnetwork.social_networking_backend.exception.InvalidAccountException;
import com.socialnetwork.social_networking_backend.exception.UsernameExistsException;
import com.socialnetwork.social_networking_backend.model.Account;
import com.socialnetwork.social_networking_backend.service.AccountService;
import com.socialnetwork.social_networking_backend.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
@RequestMapping("/api/account")
public class SocialNetworkingController {
    private final AccountService accountService;
    //private final MessageService messageService;

    public SocialNetworkingController(AccountService accountService) {
        this.accountService = accountService;
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/register")
    public ResponseEntity<Account> postRegister(@RequestBody Account account) {
        try {
            Account createdAccount = accountService.registerAccount(account);
            return ResponseEntity.ok(createdAccount);
        }
        catch (UsernameExistsException e) {
            return ResponseEntity.status(409).build();
        }
        catch (InvalidAccountException e) {
            return ResponseEntity.status(400).build();
        }
    }
}
