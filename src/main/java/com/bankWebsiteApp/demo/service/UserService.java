package com.bankWebsiteApp.demo.service;

import com.bankWebsiteApp.demo.dto.UserBankDTO;
import com.bankWebsiteApp.demo.exceptions.MessageNotFoundException;
import com.bankWebsiteApp.demo.mapper.UserMapper;
import com.bankWebsiteApp.demo.models.UserBank;
import com.bankWebsiteApp.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserBank CriarConta(UserBank userBank) {
        return userRepository.save(userBank);
    }

    public UserBankDTO ConsultAccountUser(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toDTOUser)
                .orElseThrow(()-> MessageNotFoundException.NotFoundUserId(id));

    }
    public UserBank getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}

