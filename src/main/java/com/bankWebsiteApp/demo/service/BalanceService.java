package com.bankWebsiteApp.demo.service;

import com.bankWebsiteApp.demo.CardConfiguration.CardCreditLimit;
import com.bankWebsiteApp.demo.dto.UserBankDTO;
import com.bankWebsiteApp.demo.models.Balance;
import com.bankWebsiteApp.demo.models.UserBank;
import com.bankWebsiteApp.demo.repository.BalanceRepository;
import com.bankWebsiteApp.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BalanceService {

    private final BalanceRepository balanceRepository;
    private final UserRepository userRepository;

    public Balance createBalance (Balance balance) {

        int generatedLimt = CardCreditLimit.generateLimitCredit();
        balance.setCredit(generatedLimt);

        UserBank userBank = userRepository.findById(balance.
                getAccountUserBank().getIdUser()).orElse(null);
        assert userBank != null;
        userRepository.save(userBank);
        balance.setAccountUserBank(userBank);
        return balanceRepository.save(balance);
    }

    public Balance getBalanceForUserBank(UserBankDTO userBank) {
        return balanceRepository.findByAccountUserBank(userBank);
    }
}
