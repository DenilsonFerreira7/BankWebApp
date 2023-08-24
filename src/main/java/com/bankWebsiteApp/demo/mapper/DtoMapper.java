package com.bankWebsiteApp.demo.mapper;

import com.bankWebsiteApp.demo.dto.AccountUserDto;
import com.bankWebsiteApp.demo.dto.BalanceDto;
import com.bankWebsiteApp.demo.dto.UserBankDto;
import com.bankWebsiteApp.demo.models.AccountUser;
import com.bankWebsiteApp.demo.models.Balance;
import com.bankWebsiteApp.demo.models.UserBank;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DtoMapper {
    private final ModelMapper modelMapper;

    public DtoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UserBankDto convertToUserBankDto(UserBank userBank) {
        return modelMapper.map(userBank, UserBankDto.class);
    }

    public BalanceDto convertToBalanceDto(Balance balance) {
        return modelMapper.map(balance, BalanceDto.class);
    }

    public AccountUserDto convertToAccountUserDto(AccountUser accountUser) {
        return modelMapper.map(accountUser, AccountUserDto.class);
    }
}
