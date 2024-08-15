package com.bankWebsiteApp.demo.controller;

import com.bankWebsiteApp.demo.models.Balance;
import com.bankWebsiteApp.demo.service.BalanceService;
import com.bankWebsiteApp.demo.util.ResponseMessagesSuccessful;
import com.bankWebsiteApp.demo.validation.balanceValidate.BalanceValidation;
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
    private final BalanceValidation balanceValidation;

    @PostMapping(value = "/created", produces = "application/json")
    public ResponseEntity<ResponseMessagesSuccessful> balanceCreated(@RequestBody Balance balance) {
        Long userId = balance.getAccountUserBank().getIdUser();
        boolean isFirstDeposit = balanceValidation.isFirstDeposit(userId);

        Balance balanceCreated = balanceService.createOrUpdateBalance(balance);

        ResponseMessagesSuccessful responseMessage = ResponseMessagesSuccessful.balanceCreated(balanceCreated.getCredit(), isFirstDeposit);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseMessage);
    }
}
