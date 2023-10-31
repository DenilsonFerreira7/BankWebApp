package com.bankWebsiteApp.demo.service;

import com.bankWebsiteApp.demo.dto.CardUserDTO;
import com.bankWebsiteApp.demo.dto.CombinedDTO;
import com.bankWebsiteApp.demo.dto.UserBankDTO;
import com.bankWebsiteApp.demo.mapper.DtoMapper;
import com.bankWebsiteApp.demo.models.Balance;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CombinedService {

    private final UserService userService;

    private final BalanceService balanceService;

    private final CardUserService cardUserService;

    private final DtoMapper dtoMapper;


    public CombinedDTO getCombinedDataById(Long id) {
        UserBankDTO userBankOptional = userService.ConsultAccountUser(id);
        UserBankDTO userBank = userBankOptional;

        Balance balance = balanceService.getBalanceForUserBank(userBank);
        CardUserDTO cardUserDto = cardUserService.getAccountUserDtoByAccountUserBank(userBank.getIdUser());

        CombinedDTO combinedDataDto = new CombinedDTO();
        combinedDataDto.setUserBankDto(dtoMapper.convertToUserBankDto(userBank));
        combinedDataDto.setBalanceDto(dtoMapper.convertToBalanceDto(balance));
        combinedDataDto.setCardUserDto(cardUserDto);

        return combinedDataDto;
    }
}
