package com.bankWebsiteApp.demo.mapper;

import com.bankWebsiteApp.demo.dto.TransactionRequestDto;
import com.bankWebsiteApp.demo.models.Transaction;
import org.springframework.stereotype.Service;

@Service
public class TransactionBuilder {

    public Transaction createTransaction(TransactionRequestDto transactionRequest) {
        Transaction transaction = new Transaction();
        transaction.setAccountUserBank(transactionRequest.getIdUser());
        transaction.setBalance(transactionRequest.getIdBalance());
        transaction.setTransactionType(transactionRequest.getTransactionType());
        transaction.setTransactionAmount(transactionRequest.getTransactionAmount());
        transaction.setBeneficiaryNum(transactionRequest.getBeneficiaryNum());
        return transaction;
    }
}

