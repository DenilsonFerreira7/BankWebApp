package com.bankWebsiteApp.demo.mapper;

import com.bankWebsiteApp.demo.dto.CardUserDTO;
import com.bankWebsiteApp.demo.dto.BalanceDTO;
import com.bankWebsiteApp.demo.dto.UserBankDTO;
import com.bankWebsiteApp.demo.models.Balance;
import com.bankWebsiteApp.demo.models.CardUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DtoMapper {
    private final ModelMapper modelMapper;

    public DtoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UserBankDTO convertToUserBankDto(UserBankDTO userBank) {
        return modelMapper.map(userBank, UserBankDTO.class);
    }

    public BalanceDTO convertToBalanceDto(Balance balance) {
        return modelMapper.map(balance, BalanceDTO.class);
    }

    public CardUserDTO convertToAccountUserDto(CardUser cardUser) {
        return modelMapper.map(cardUser, CardUserDTO.class);
    }
}
