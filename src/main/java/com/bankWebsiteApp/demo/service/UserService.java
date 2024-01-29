package com.bankWebsiteApp.demo.service;

import com.bankWebsiteApp.demo.dto.UserBankDTO;
import com.bankWebsiteApp.demo.models.UserBank;
import com.bankWebsiteApp.demo.repository.UserRepository;
import com.bankWebsiteApp.demo.validation.user.CPFValidation;
import com.bankWebsiteApp.demo.validation.user.UserValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserValidation userValidation;
    private final CPFValidation cpfValidation;

    public UserBank CriarConta(UserBank userBank) throws IllegalAccessException {
        cpfValidation.CPFValidation(userBank);
        return userRepository.save(userBank);
    }

    public UserBankDTO ConsultAccountUser(Long id) {
        return userValidation.validateUserId(id);
    }

    public Optional<UserBank> getUserById (Long id){
        return userRepository.findById(id);
    }
}

