package com.bankWebsiteApp.demo.validation.transaction;

import com.bankWebsiteApp.demo.exceptions.MessageNotFoundException;
import com.bankWebsiteApp.demo.models.Balance;
import com.bankWebsiteApp.demo.models.CardUser;

// Garantir que o ID do usuário associado ao saldo (Balance) seja igual ao ID fornecido durante a transação
public class TransactionBalanceIdValidation implements TransactionInterface {
    private final Balance balance;

    public TransactionBalanceIdValidation(Balance balance) {
        this.balance = balance;
    }

    @Override
    public void validate(CardUser cardUser, String passwordCard, Long userId, Long balanceId) {
        if (!balance.getAccountUserBank().getIdUser().equals(userId)) {
            throw MessageNotFoundException.BalanceNotReference(userId);
        }
    }
}
