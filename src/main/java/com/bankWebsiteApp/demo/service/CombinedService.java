package com.bankWebsiteApp.demo.service;

import com.bankWebsiteApp.demo.dto.CombinedDTO;
import com.bankWebsiteApp.demo.mapper.DtoMapper;
import com.bankWebsiteApp.demo.models.Balance;
import com.bankWebsiteApp.demo.models.CardUser;
import com.bankWebsiteApp.demo.models.UserBank;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CombinedService {

    private final UserService userService;
    private final BalanceService balanceService;
    private final CardUserService cardUserService;
    private final DtoMapper dtoMapper;


    public CombinedDTO getUserDetails(Long userId) {
        Balance balance = balanceService.getBalanceForUserBank(userId);
        CardUser cardUser = cardUserService.getCardUserByUserId(userId);
        Optional<UserBank> userBankOptional = userService.getUserById(userId);

        if (userBankOptional.isPresent()) {
            UserBank userBank = userBankOptional.get();
            CombinedDTO userBankInfos = dtoMapper.mapToDTO(Optional.of(userBank), balance, cardUser);

            CombinedDTO combinedDataDto = new CombinedDTO();
            combinedDataDto.setUsername(String.valueOf(userBankInfos));
            return combinedDataDto;
        } else {
            // Lida com o caso em que o usuário não foi encontrado
            // Você pode lançar uma exceção ou retornar um DTO de erro, por exemplo.
            return null; // Ou outra ação apropriada
        }
    }
}