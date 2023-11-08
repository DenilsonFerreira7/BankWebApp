package com.bankWebsiteApp.demo.validation;

import com.bankWebsiteApp.demo.dto.UserBankDTO;
import com.bankWebsiteApp.demo.exceptions.MessageNotFoundException;
import com.bankWebsiteApp.demo.mapper.UserMapper;
import com.bankWebsiteApp.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserValidation {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserBankDTO validateUserId(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toDTOUser)
                .orElseThrow(() -> MessageNotFoundException.NotFoundUserId(id));
    }

}
