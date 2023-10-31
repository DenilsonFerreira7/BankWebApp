package com.bankWebsiteApp.demo.mapper;

import com.bankWebsiteApp.demo.dto.CardUserDto;
import com.bankWebsiteApp.demo.models.CardUser;
import org.springframework.stereotype.Component;
@Component
public class ConsultMapper {
    public CardUserDto toDto(CardUser cardUser) {
        CardUserDto cardUserDto = new CardUserDto();
        cardUserDto.setNumberCard(cardUser.getNumberCard());
        cardUserDto.setPasswordCard(Long.toString(cardUser.getAccountUserBank().getIdUser()));
        return cardUserDto;
    }
}

