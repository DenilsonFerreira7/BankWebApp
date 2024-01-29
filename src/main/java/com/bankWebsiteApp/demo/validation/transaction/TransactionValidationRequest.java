package com.bankWebsiteApp.demo.validation.transaction;

import com.bankWebsiteApp.demo.exceptions.MessageNotFoundException;
import com.bankWebsiteApp.demo.models.Balance;
import com.bankWebsiteApp.demo.models.CardUser;
import com.bankWebsiteApp.demo.repository.BalanceRepository;
import com.bankWebsiteApp.demo.repository.CardUserRepository;
import com.bankWebsiteApp.demo.validation.card.CardAccountValidation;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

// Classe que utiliza as implementações de TransactionValidator
@Component
@RequiredArgsConstructor

public class TransactionValidationRequest {

    private final CardUserRepository cardUserRepository;
    private final BalanceRepository balanceRepository;

    public void validateTransaction(String numberCard, String passwordCard, Long userId, Long balanceId, long idBalance) {
        CardUser cardUser = cardUserRepository.findByNumberCard(numberCard);
        Balance balance = balanceRepository.findById(balanceId)
                .orElseThrow(() -> MessageNotFoundException.BalanceNotReference(balanceId));

        // Lista de validadores
        List<TransactionInterface> validators = Arrays.asList(
                new CardAccountValidation(),
                new TransactionBalanceIdValidation(balance)
        );

        // Executa as validações
        validators.forEach(validator -> validator.validate(cardUser, passwordCard, userId, balanceId));
    }
}
