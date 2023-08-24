package com.bankWebsiteApp.demo.service;

import com.bankWebsiteApp.demo.dto.AccountUserDto;
import com.bankWebsiteApp.demo.dto.CombinedDto;
import com.bankWebsiteApp.demo.mapper.DtoMapper;
import com.bankWebsiteApp.demo.models.Balance;
import com.bankWebsiteApp.demo.models.UserBank;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CombinedService {

    private final UserService userService;

    private final BalanceService balanceService;

    private final AccountUserService accountUserService;

    private final DtoMapper dtoMapper;


    public CombinedDto getCombinedDataById(Long id) {
        Optional<UserBank> userBankOptional = userService.ConsultAccountUser(id);
        UserBank userBank = userBankOptional.orElse(null);

        Balance balance = balanceService.getBalanceForUserBank(userBank);
        AccountUserDto accountUserDto = accountUserService.getAccountUserDtoByAccountUserBank(userBank.getIdUser());

        CombinedDto combinedDataDto = new CombinedDto();
        combinedDataDto.setUserBankDto(dtoMapper.convertToUserBankDto(userBank));
        combinedDataDto.setBalanceDto(dtoMapper.convertToBalanceDto(balance));
        combinedDataDto.setAccountUserDto(accountUserDto);

        return combinedDataDto;
    }
}
