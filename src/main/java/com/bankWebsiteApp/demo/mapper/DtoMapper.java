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


    public CombinedDTO mapToDTO(Optional<UserBank> userBank, Balance balance, CardUser cardUser) {
        CombinedDTO userDetailsDTO = modelMapper.map(userBank, CombinedDTO.class);
        userDetailsDTO.setDebit(balance.getDebit());
        userDetailsDTO.setCredit(balance.getCredit());
        userDetailsDTO.setNumberCard(cardUser.getNumberCard());
        return userDetailsDTO;
    }
}
