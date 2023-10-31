package com.bankWebsiteApp.demo.service;

import com.bankWebsiteApp.demo.CardConfiguration.CardNumberGenerator;
import com.bankWebsiteApp.demo.dto.CardUserDTO;
import com.bankWebsiteApp.demo.mapper.ConsultMapper;
import com.bankWebsiteApp.demo.models.CardUser;
import com.bankWebsiteApp.demo.models.UserBank;
import com.bankWebsiteApp.demo.repository.CardUserRepository;
import com.bankWebsiteApp.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CardUserService {
    private final CardUserRepository cardUserRepository;

    private final UserRepository userRepository;
    private final ConsultMapper consultMapper;


    public CardUser createAccount(CardUser cardUser) {
        UserBank userBank = cardUser.getAccountUserBank();

        if (userBank == null || userBank.getIdUser() == null || !userRepository.existsById(userBank.getIdUser())) {
            throw new IllegalArgumentException("UserBank não encontrado ou ID inválido.");
        }
        String generatedNumber = CardNumberGenerator.generateRandomNumber();
        cardUser.setNumberCard(generatedNumber);
        cardUserRepository.save(cardUser);
        return cardUser;
    }

    public CardUserDTO getAccountUserDtoByAccountUserBank(Long accountUserBankId) {
        CardUser cardUser = cardUserRepository.findByAccountUserBankIdUser(accountUserBankId);
        return consultMapper.toDto(cardUser);
    }
}