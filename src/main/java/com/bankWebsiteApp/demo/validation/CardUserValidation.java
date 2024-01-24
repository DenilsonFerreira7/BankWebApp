//package com.bankWebsiteApp.demo.validation;
//
//import com.bankWebsiteApp.demo.CardConfiguration.CardNumberGenerator;
//import com.bankWebsiteApp.demo.models.CardUser;
//import com.bankWebsiteApp.demo.models.UserBank;
//import com.bankWebsiteApp.demo.repository.CardUserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//@RequiredArgsConstructor
//@Service
//public class CardUserValidation {
//
//    private final CardUserRepository cardUserRepository;
//    private final CardNumberGenerator cardNumberGenerator;
//
//    public String generateUniqueCardNumber(UserBank userBank) {
//        String generatedNumber;
//
//        do {
//            generatedNumber = cardNumberGenerator.generateRandomNumber();
//        } while (!isUnique(generatedNumber));
//
//        return generatedNumber;
//    }
//
//    private boolean isUnique(String generatedNumber) {
//        CardUser existingCardUser = cardUserRepository.findByNumberCard(generatedNumber);
//        return existingCardUser == null;
//    }
//}