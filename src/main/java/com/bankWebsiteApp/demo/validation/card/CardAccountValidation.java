package com.bankWebsiteApp.demo.validation.card;

import com.bankWebsiteApp.demo.exceptions.MessageNotFoundException;
import com.bankWebsiteApp.demo.models.CardUser;
import com.bankWebsiteApp.demo.validation.transaction.TransactionInterface;

// Implementação específica para a validação de número de cartão
public class CardAccountValidation implements TransactionInterface {
    @Override
    public void validate(CardUser cardUser, String passwordCard, Long userId, Long balanceId) {
        if (cardUser == null) {
            throw MessageNotFoundException.NotFoundCardNumber(cardUser.getNumberCard());
        }
        if (!cardUser.getPasswordCard().equals(passwordCard)) {
            throw MessageNotFoundException.NotFoundCardPassword(passwordCard);
        }
    }
}
