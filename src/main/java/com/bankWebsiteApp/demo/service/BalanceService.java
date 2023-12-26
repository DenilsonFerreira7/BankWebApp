package com.bankWebsiteApp.demo.service;

import com.bankWebsiteApp.demo.CardConfiguration.CardCreditLimit;
import com.bankWebsiteApp.demo.models.Balance;
import com.bankWebsiteApp.demo.models.UserBank;
import com.bankWebsiteApp.demo.repository.BalanceRepository;
import com.bankWebsiteApp.demo.repository.UserRepository;
import com.bankWebsiteApp.demo.validation.BalanceValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BalanceService {

    private final BalanceRepository balanceRepository;
    private final UserRepository userRepository;
    private final BalanceValidation balanceValidation;

    public Balance createBalance(Balance balance) {
        Long userId = balance.getAccountUserBank().getIdUser();
        balanceValidation.validateUserExistence(userId);

        int generatedLimit = CardCreditLimit.generateLimitCredit();
        balance.setCredit(generatedLimit);

        UserBank userBank = userRepository.findById(userId).get();

        balance.setAccountUserBank(userBank);
        userRepository.save(userBank);

        return balanceRepository.save(balance);
    }


    public Balance getBalanceForUserBank(Long userBank) {
        return balanceRepository.findByAccountUserBank(userBank);
    }
}