package com.bankWebsiteApp.demo.validation.balanceValidate;

import com.bankWebsiteApp.demo.exceptions.MessageNotFoundException;
import com.bankWebsiteApp.demo.repository.BalanceRepository;
import com.bankWebsiteApp.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BalanceValidation {

    private final UserRepository userRepository;
    private final BalanceRepository balanceRepository;

    public void validateUserExistence(Long userId) {
        if (userId == null) {
            throw MessageNotFoundException.NotFoundUserId(userId);
        }

        userRepository.findById(userId).orElseThrow(() -> MessageNotFoundException.NotFoundUserId(userId));
    }
    public boolean isFirstDeposit (Long userID) {
        return balanceRepository.findByAccountUserBank_IdUser(userID).isEmpty();
    }


}