package com.bankWebsiteApp.demo.service;

import com.bankWebsiteApp.demo.dto.TransactionRequestDto;
import com.bankWebsiteApp.demo.mapper.TransactionBuilder;
import com.bankWebsiteApp.demo.models.Transaction;
import com.bankWebsiteApp.demo.repository.CardUserRepository;
import com.bankWebsiteApp.demo.repository.TransactionRepository;
import com.bankWebsiteApp.demo.validation.CardUserValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final CardUserRepository cardUserRepository;
    private final TransactionBuilder transactionBuilder;
    private final CardUserValidation cardUserValidation;


    public void createTransaction(TransactionRequestDto transactionRequest) {
        // Valide o número do cartão e a senha do cartão usando o serviço de validação.
        cardUserValidation.validateCardUser(
                transactionRequest.getCardUser().getNumberCard(),
                transactionRequest.getCardUser().getPasswordCard()
        );

        // Crie a transação usando o construtor de transação.
        Transaction transaction = transactionBuilder.createTransaction(transactionRequest);

        // Salve a transação no banco de dados.
        transactionRepository.save(transaction);
    }
}