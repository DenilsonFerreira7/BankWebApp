package com.bankWebsiteApp.demo.controller;

import com.bankWebsiteApp.demo.dto.AccountUserDto;
import com.bankWebsiteApp.demo.models.AccountUser;
import com.bankWebsiteApp.demo.service.AccountUserService;
import com.bankWebsiteApp.demo.util.ResponseMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountUserService accountUserService;
    private final AccountUserService accountUserDtoService;


    @PostMapping(value = "/create", produces = "application/json")
    public ResponseEntity<ResponseMessages> createAccount (@RequestBody AccountUser accountUser){
        AccountUser createdAccount = accountUserService.createAccount(accountUser);
        return ResponseEntity.status(HttpStatus.CREATED).
                body(ResponseMessages.accountCreated(createdAccount.getNumberAccount()));
    }
    @GetMapping(value = "/{accountUserBankId}", produces = "application/json")
    public AccountUserDto getAccountUserDto(@PathVariable Long accountUserBankId) {
        return accountUserService.getAccountUserDtoByAccountUserBank(accountUserBankId);
    }
}
