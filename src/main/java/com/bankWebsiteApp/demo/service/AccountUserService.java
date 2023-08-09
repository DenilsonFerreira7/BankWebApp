package com.bankWebsiteApp.demo.service;

import com.bankWebsiteApp.demo.CardConfiguration.CardNumberGenerator;
import com.bankWebsiteApp.demo.models.AccountUser;
import com.bankWebsiteApp.demo.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AccountUserService {

  private final  AccountRepository accountRepository;

    public AccountUser createAccount (AccountUser accountUser) {
        String generatedNumber = CardNumberGenerator.generateRandomNumber();
        accountUser.setNumberAccount(generatedNumber);
        return accountRepository.save(accountUser);
    }

    public AccountUser AccountConsult (String numberAccount) {
        AccountUser accountUser = accountRepository.findByNumberAccount(numberAccount);
        return accountRepository.findByNumberAccount(numberAccount);
    }
}