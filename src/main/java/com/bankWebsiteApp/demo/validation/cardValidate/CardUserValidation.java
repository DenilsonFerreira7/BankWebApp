package com.bankWebsiteApp.demo.validation.cardValidate;

import com.bankWebsiteApp.demo.exceptions.MessageNotFoundException;
import com.bankWebsiteApp.demo.models.UserBank;
import com.bankWebsiteApp.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CardUserValidation {

    private final UserRepository userRepository;

    public void validateUserCardBank (UserBank userBank) {
        if (userBank == null || userBank.getIdUser() == null || !userRepository.existsById(userBank.getIdUser())) {
            throw MessageNotFoundException.NotFoundUserId(userBank.getIdUser());
        }
    }
}
