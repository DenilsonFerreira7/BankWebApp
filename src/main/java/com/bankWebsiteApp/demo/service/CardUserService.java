package com.bankWebsiteApp.demo.service;

import com.bankWebsiteApp.demo.CardConfiguration.CardNumberGenerator;
import com.bankWebsiteApp.demo.dto.CardUserDTO;
import com.bankWebsiteApp.demo.mapper.ConsultMapper;
import com.bankWebsiteApp.demo.models.CardUser;
import com.bankWebsiteApp.demo.models.UserBank;
import com.bankWebsiteApp.demo.repository.CardUserRepository;
import com.bankWebsiteApp.demo.validation.CardUserValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CardUserService {
    private final CardUserRepository cardUserRepository;
    private final ConsultMapper consultMapper;
    private final CardUserValidation cardUserValidation;


    public CardUser createAccount(CardUser cardUser) {

        UserBank userBank = cardUser.getAccountUserBank();
        cardUserValidation.validateUserCardBank(userBank);

        String generatedNumber = CardNumberGenerator.generateRandomNumber();
        cardUser.setNumberCard(generatedNumber);
        cardUserRepository.save(cardUser);
        return cardUser;
    }

    public CardUserDTO getAccountUserDtoByAccountUserBank(Long accountUserBankId) {
        CardUser cardUser = cardUserRepository.findByAccountUserBankIdUser(accountUserBankId);
        return consultMapper.toDto(cardUser);
    }
    public CardUser getCardUserByUserId (Long id){
        return cardUserRepository.findByAccountUserBankIdUser(id);
    }
}