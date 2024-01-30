package com.bankWebsiteApp.demo.service;

import com.bankWebsiteApp.demo.dto.CombinedDTO;
import com.bankWebsiteApp.demo.models.Balance;
import com.bankWebsiteApp.demo.models.CardUser;
import com.bankWebsiteApp.demo.models.UserBank;
import com.bankWebsiteApp.demo.repository.BalanceRepository;
import com.bankWebsiteApp.demo.repository.CardUserRepository;
import com.bankWebsiteApp.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CombinedService {

    private final UserRepository userRepository;
    private final BalanceRepository balanceRepository;
    private final CardUserRepository cardUserRepository;

    public CombinedDTO getUserInfoById(Long userId) {
        UserBank userBank = userRepository.findById(userId).orElse(null);
        if (userBank == null) {
            return null; // Handle user not found
        }

        Balance balance = balanceRepository.findByAccountUserBank(userBank);
        CardUser cardUser = cardUserRepository.findByAccountUserBank(userBank);

        return new CombinedDTO(
                userId,
                balance != null ? balance.getDebit() : 0,
                balance != null ? balance.getCredit() : 0,
                cardUser != null ? cardUser.getNumberCard() : null,
                userBank.getName(),
                userBank.getTelephone(),
                userBank.getCpfUser()
        );
    }
}