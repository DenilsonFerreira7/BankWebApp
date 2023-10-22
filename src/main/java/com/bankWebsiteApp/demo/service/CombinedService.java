package com.bankWebsiteApp.demo.service;

import com.bankWebsiteApp.demo.dto.CardUserDto;
import com.bankWebsiteApp.demo.dto.CombinedDto;
import com.bankWebsiteApp.demo.mapper.DtoMapper;
import com.bankWebsiteApp.demo.models.Balance;
import com.bankWebsiteApp.demo.models.UserBank;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CombinedService {

    private final UserService userService;

    private final BalanceService balanceService;

    private final CardUserService cardUserService;

    private final DtoMapper dtoMapper;


    public CombinedDto getCombinedDataById(Long id) {
        UserBank userBankOptional = userService.ConsultAccountUser(id);
        UserBank userBank = userBankOptional;

        Balance balance = balanceService.getBalanceForUserBank(userBank);
        CardUserDto cardUserDto = cardUserService.getAccountUserDtoByAccountUserBank(userBank.getIdUser());

        CombinedDto combinedDataDto = new CombinedDto();
        combinedDataDto.setUserBankDto(dtoMapper.convertToUserBankDto(userBank));
        combinedDataDto.setBalanceDto(dtoMapper.convertToBalanceDto(balance));
        combinedDataDto.setCardUserDto(cardUserDto);

        return combinedDataDto;
    }
}
