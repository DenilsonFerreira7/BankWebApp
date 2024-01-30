package com.bankWebsiteApp.demo.service;

import com.bankWebsiteApp.demo.dto.UserBankDTO;
import com.bankWebsiteApp.demo.models.UserBank;
import com.bankWebsiteApp.demo.repository.UserBankRepository;
import com.bankWebsiteApp.demo.validation.userValidate.UserValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserBankService {

    private final UserBankRepository userBankRepository;
    private final UserValidation userValidation;

    public UserBank CriarConta(UserBank userBank) {
        return userBankRepository.save(userBank);
    }

    public UserBankDTO ConsultAccountUser(Long id) {
        return userValidation.validateUserId(id);
    }

    public Optional<UserBank> getUserById (Long id){
        return userBankRepository.findById(id);
    }
}

