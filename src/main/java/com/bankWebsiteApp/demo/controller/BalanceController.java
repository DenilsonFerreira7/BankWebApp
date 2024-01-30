package com.bankWebsiteApp.demo.controller;

import com.bankWebsiteApp.demo.models.Balance;
import com.bankWebsiteApp.demo.service.BalanceService;
import com.bankWebsiteApp.demo.util.ResponseMessagesSuccessful;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/accountBalance")
public class BalanceController {

    private final BalanceService balanceService;

    @PostMapping(value = "/created", produces = "application/json")
    public ResponseEntity balanceCreated (@RequestBody Balance balance){
        Balance balanceCreated = balanceService.createFirstBalance(balance);
        return  ResponseEntity.status(HttpStatus.CREATED).
                body(ResponseMessagesSuccessful.balanceCreated(balanceCreated.getCredit()));
    }
}