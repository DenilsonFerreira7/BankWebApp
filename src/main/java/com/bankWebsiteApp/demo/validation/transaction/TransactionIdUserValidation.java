package com.bankWebsiteApp.demo.validation.transaction;

import com.bankWebsiteApp.demo.exceptions.MessageNotFoundException;
import com.bankWebsiteApp.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

// Garante existência do usuario antes da transação
@RequiredArgsConstructor
@Service
public class TransactionIdUserValidation {

    private final UserRepository userRepository;

    public void validateUserExistence(Long userId) {
        if (userId == null) {
            throw MessageNotFoundException.NotFoundUserId(userId);
        }

        userRepository.findById(userId).orElseThrow(() -> MessageNotFoundException.NotFoundUserId(userId));
    }
}