package com.bankWebsiteApp.demo.validation.user;

import com.bankWebsiteApp.demo.exceptions.MessageNotFoundException;
import com.bankWebsiteApp.demo.models.UserBank;
import com.bankWebsiteApp.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.aspectj.bridge.Message;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CPFValidation {

    private final UserRepository userRepository;


    public void  CPFValidation (UserBank userBank) throws IllegalAccessException {
        validateUniqueCPF (userBank.getCpfUser());

    }

    private void validateUniqueCPF (String cpf) throws IllegalAccessException {
        if (userRepository.existsByCpfUser(cpf)) {
            throw MessageNotFoundException.CPFAlreadyExists(cpf);
        }
    }
}
