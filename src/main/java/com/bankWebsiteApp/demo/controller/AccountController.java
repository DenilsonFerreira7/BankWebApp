package com.bankWebsiteApp.demo.controller;

import com.bankWebsiteApp.demo.models.AccountUser;
import com.bankWebsiteApp.demo.service.AccountUserService;
import com.bankWebsiteApp.demo.util.ResponseMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountUserService accountUserService;

    @PostMapping(value = "/create", produces = "application/json")
    public ResponseEntity<ResponseMessages> createAccount (@RequestBody AccountUser accountUser){
        AccountUser createdAccount = accountUserService.createAccount(accountUser);
        return ResponseEntity.status(HttpStatus.CREATED).
                body(ResponseMessages.accountCreated(createdAccount.getNumberAccount()));
    }
}
