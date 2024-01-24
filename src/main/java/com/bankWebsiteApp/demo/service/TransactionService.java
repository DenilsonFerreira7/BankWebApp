package com.bankWebsiteApp.demo.service;

import com.bankWebsiteApp.demo.dto.TransactionRequestDto;
import com.bankWebsiteApp.demo.mapper.TransactionBuilder;
import com.bankWebsiteApp.demo.models.Transaction;
import com.bankWebsiteApp.demo.repository.TransactionRepository;
import com.bankWebsiteApp.demo.validation.TransactionValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionBuilder transactionBuilder;
    private final TransactionValidation transactionValidation;

    public void createTransaction(TransactionRequestDto transactionRequest) {
        // Adicionando validação da transação e do cartão
        transactionValidation.validateTransaction(
                transactionRequest.getCardUser().getNumberCard(),
                transactionRequest.getCardUser().getPasswordCard(),
                transactionRequest.getIdBalance().getIdBalance(),
                transactionRequest.getIdUser().getIdUser(),
                transactionRequest.getIdBalance().getIdBalance()
        );

        // Criar a transação usando o TransactionBuilder
        Transaction transaction = transactionBuilder.createTransaction(transactionRequest);

        // Salvar a transação no repositório
        transactionRepository.save(transaction);
    }
}