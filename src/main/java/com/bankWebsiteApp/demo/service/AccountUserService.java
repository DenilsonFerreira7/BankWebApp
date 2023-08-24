package com.bankWebsiteApp.demo.service;

import com.bankWebsiteApp.demo.CardConfiguration.CardNumberGenerator;
import com.bankWebsiteApp.demo.dto.AccountUserDto;
import com.bankWebsiteApp.demo.mapper.ConsultMapper;
import com.bankWebsiteApp.demo.models.AccountUser;
import com.bankWebsiteApp.demo.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AccountUserService {
    private final  AccountRepository accountRepository;
    private final ConsultMapper consultMapper;


    public AccountUser createAccount (AccountUser accountUser) {
        String generatedNumber = CardNumberGenerator.generateRandomNumber();
        accountUser.setNumberAccount(generatedNumber);
        return accountRepository.save(accountUser);
    }

    public AccountUserDto getAccountUserDtoByAccountUserBank(Long accountUserBankId) {
        AccountUser accountUser = accountRepository.findByAccountUserBankIdUser(accountUserBankId);
        return consultMapper.toDto(accountUser);
    }
}