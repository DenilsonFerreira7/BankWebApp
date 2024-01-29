package com.bankWebsiteApp.demo.validation.transaction;

import com.bankWebsiteApp.demo.models.CardUser;

public interface TransactionInterface {
    void validate(CardUser cardUser, String passwordCard, Long userId, Long balanceId);
}
