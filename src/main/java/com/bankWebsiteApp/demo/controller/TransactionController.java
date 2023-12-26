package com.bankWebsiteApp.demo.controller;

import com.bankWebsiteApp.demo.dto.TransactionRequestDto;
import com.bankWebsiteApp.demo.service.TransactionService;
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
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/create")
    public ResponseEntity createTransaction(@RequestBody TransactionRequestDto transactionRequest) {
        try {
            transactionService.createTransaction(transactionRequest);
            return ResponseEntity.status(HttpStatus.CREATED).
                    body(ResponseMessagesSuccessful.transactionSucess(transactionRequest.getBeneficiaryNum()));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}