package com.bankWebsiteApp.demo.mapper;

import com.bankWebsiteApp.demo.dto.CombinedDTO;
import com.bankWebsiteApp.demo.models.Balance;
import com.bankWebsiteApp.demo.models.CardUser;
import com.bankWebsiteApp.demo.models.UserBank;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DtoMapper {
    private final ModelMapper modelMapper;


    public  CombinedDTO mapToDTO(Optional<UserBank> userBankOptional, Balance balance, CardUser cardUser) {
        CombinedDTO userDetailsDTO = new CombinedDTO();

        if (userBankOptional.isPresent()) {
            UserBank userBank = userBankOptional.get();

            // Mapeia os campos do UserBankDTO
            userDetailsDTO = modelMapper.map(userBank, CombinedDTO.class);
        }

        // Define os campos adicionais
        userDetailsDTO.setDebit(balance.getDebit());
        userDetailsDTO.setCredit(balance.getCredit());
        userDetailsDTO.setNumberCard(cardUser.getNumberCard());
        userDetailsDTO.setUserId(userDetailsDTO.getUserId());


        return userDetailsDTO;
    }
}
