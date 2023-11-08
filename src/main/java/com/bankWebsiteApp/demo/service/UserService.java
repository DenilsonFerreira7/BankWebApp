package com.bankWebsiteApp.demo.service;

import com.bankWebsiteApp.demo.dto.UserBankDTO;
import com.bankWebsiteApp.demo.models.UserBank;
import com.bankWebsiteApp.demo.repository.UserRepository;
import com.bankWebsiteApp.demo.validation.UserValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserValidation userValidation;

    public UserBank CriarConta(UserBank userBank) {
        return userRepository.save(userBank);
    }

    public UserBankDTO ConsultAccountUser(Long id) {
        return userValidation.validateUserId(id);
    }
}

