package com.bankWebsiteApp.demo.service;

import com.bankWebsiteApp.demo.CardConfiguration.CardNumberGenerator;
import com.bankWebsiteApp.demo.dto.CardUserDTO;
import com.bankWebsiteApp.demo.mapper.ConsultMapper;
import com.bankWebsiteApp.demo.models.CardUser;
import com.bankWebsiteApp.demo.models.UserBank;
import com.bankWebsiteApp.demo.repository.CardUserRepository;
import com.bankWebsiteApp.demo.validation.cardValidate.CardUserValidation;
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

        String generatedNumber = CardNumberGenerator.generateMastercardNumber();
        cardUser.setNumberCard(generatedNumber);
        cardUserRepository.save(cardUser);
        return cardUser;
    }

    public CardUserDTO getAccountUserDtoByAccountUserBank(UserBank accountUserBank) {
        CardUser cardUser = cardUserRepository.findByAccountUserBank(accountUserBank);
        return consultMapper.toDto(cardUser);
    }

    public CardUser getCardUserByUserId(UserBank accountUserBank) {
        return cardUserRepository.findByAccountUserBank(accountUserBank);
    }
}