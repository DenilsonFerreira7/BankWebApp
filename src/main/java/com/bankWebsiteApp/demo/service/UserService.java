package com.bankWebsiteApp.demo.service;
import com.bankWebsiteApp.demo.models.UserBank;
import com.bankWebsiteApp.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserBank CriarConta(UserBank userBank) {
        return userRepository.save(userBank);
    }

    public UserBank ConsultAccount(Long id) {
        Optional<UserBank> userBanks = userRepository.findById(id);
        return userRepository.findById(id).orElse(null);
    }
}