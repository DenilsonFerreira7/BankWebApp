package com.bankWebsiteApp.demo.mapper;

import com.bankWebsiteApp.demo.dto.CardUserDTO;
import com.bankWebsiteApp.demo.models.CardUser;
import org.springframework.stereotype.Component;
@Component
public class ConsultMapper {
    public CardUserDTO toDto(CardUser cardUser) {
        CardUserDTO cardUserDto = new CardUserDTO();
        cardUserDto.setNumberCard(cardUser.getNumberCard());
        cardUserDto.setPasswordCard(Long.toString(cardUser.getAccountUserBank().getIdUser()));
        return cardUserDto;
    }
}

