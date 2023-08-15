package com.bankWebsiteApp.demo.mapper;

import com.bankWebsiteApp.demo.dto.AccountUserDto;
import com.bankWebsiteApp.demo.models.AccountUser;
import org.springframework.stereotype.Component;
@Component
public class AccountUserMapper {
    public AccountUserDto toDto(AccountUser accountUser) {
        AccountUserDto accountUserDto = new AccountUserDto();
        accountUserDto.setNumberAccount(accountUser.getNumberAccount());
        accountUserDto.setAccountUserBank(accountUser.getAccountUserBank().getIdUser());
        return accountUserDto;
    }
}

