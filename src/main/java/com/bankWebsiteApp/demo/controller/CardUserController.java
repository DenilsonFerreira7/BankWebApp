package com.bankWebsiteApp.demo.controller;

import com.bankWebsiteApp.demo.dto.CardUserDto;
import com.bankWebsiteApp.demo.models.CardUser;
import com.bankWebsiteApp.demo.service.CardUserService;
import com.bankWebsiteApp.demo.util.ResponseMessagesSuccessful;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cardUser")
public class CardUserController {

    private final CardUserService cardUserService;
    private final CardUserService accountUserDtoService;


    @PostMapping(value = "/create", produces = "application/json")
    public ResponseEntity<ResponseMessagesSuccessful> createAccount (@RequestBody CardUser cardUser){
        CardUser createdAccount = cardUserService.createAccount(cardUser);
        return ResponseEntity.status(HttpStatus.CREATED).
                body(ResponseMessagesSuccessful.accountCreated(createdAccount.getNumberCard()));
    }
    @GetMapping(value = "/{accountUserBankId}", produces = "application/json")
    public CardUserDto getAccountUserDto(@PathVariable Long accountUserBankId) {
        return cardUserService.getAccountUserDtoByAccountUserBank(accountUserBankId);
    }
}
