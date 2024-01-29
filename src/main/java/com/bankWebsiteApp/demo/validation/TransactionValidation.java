package com.bankWebsiteApp.demo.validation;

import com.bankWebsiteApp.demo.exceptions.MessageNotFoundException;
import com.bankWebsiteApp.demo.models.Balance;
import com.bankWebsiteApp.demo.models.CardUser;
import com.bankWebsiteApp.demo.repository.BalanceRepository;
import com.bankWebsiteApp.demo.repository.CardUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TransactionValidation {

    private final CardUserRepository cardUserRepository;
    private final BalanceRepository balanceRepository;

    Balance balance;


    public void validateTransaction(String numberCard, String passwordCard, Long userId, Long balanceId) {
        CardUser cardUser = cardUserRepository.findByNumberCard(numberCard);

        if (cardUser == null) {
            throw MessageNotFoundException.NotFoundCardNumber(numberCard);
        }

        if (!cardUser.getPasswordCard().equals(passwordCard)) {
            throw MessageNotFoundException.NotFoundCardPassword(passwordCard);
        }

        // Carregar o Balance do repositório
        balance = balanceRepository.findById(balanceId)
                .orElseThrow(() -> MessageNotFoundException.BalanceNotReference(balanceId));

        // Verificar se o id do usuário no Saldo corresponde ao id fornecido
        if (!balance.getAccountUserBank().getIdUser().equals(userId)) {
            throw MessageNotFoundException.NotFounIdBalance(userId);
        }

        // Verificar se o id do usuário no cartão corresponde ao id fornecido
        if (!cardUser.getAccountUserBank().getIdUser().equals(userId)) {
            throw MessageNotFoundException.NotFoundUserId(userId);
        }
    }
}