package com.bankWebsiteApp.demo.mapper;

import com.bankWebsiteApp.demo.dto.UserBankDTO;
import com.bankWebsiteApp.demo.models.UserBank;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserBankDTO toDTOUser (UserBank userBank){
        UserBankDTO userBankDTO = new UserBankDTO();
        userBankDTO.setIdUser(userBank.getIdUser());
        userBankDTO.setName(userBank.getName());
        userBankDTO.setTelephone(userBank.getTelephone());
        userBankDTO.setEmailUser(userBank.getEmailUser());
        userBankDTO.setCpfUser(userBank.getCpfUser());
        return userBankDTO;
    }

}
