package com.bankWebsiteApp.demo.validation;

import com.bankWebsiteApp.demo.models.CardUser;
import com.bankWebsiteApp.demo.repository.CardUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class CardUserValidation {

    private final CardUserRepository cardUserRepository;


    public void validateCardUser(String numberCard, String passwordCard) {
        CardUser cardUser = cardUserRepository.findByNumberCard(numberCard);

        if (cardUser == null || !cardUser.getPasswordCard().equals(passwordCard)) {
            throw new IllegalArgumentException("Senha do cartão inválida.");
        }
    }
}
