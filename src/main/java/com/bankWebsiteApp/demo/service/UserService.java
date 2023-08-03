package com.bankWebsiteApp.demo.service;
import com.bankWebsiteApp.demo.models.UserBank;
import com.bankWebsiteApp.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserBank CriarConta (UserBank userBank) {
        return userRepository.save(userBank);
    }
}
