package com.bankWebsiteApp.demo.validation.card;

import com.bankWebsiteApp.demo.CardConfiguration.CardNumberGenerator;
import com.bankWebsiteApp.demo.models.CardUser;
import com.bankWebsiteApp.demo.repository.CardUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CardNumberValidation {
    private final CardUserRepository cardUserRepository;
    private final CardNumberGenerator cardNumberGenerator;

        public String generateUniqueCardNumber() {
            String generatedNumber;

            do {
                generatedNumber = CardNumberGenerator.generateMastercardNumber();
            } while (!isUnique(generatedNumber));

            return generatedNumber;
        }

        private boolean isUnique(String generatedNumber) {
            CardUser existingCardUser = cardUserRepository.findByNumberCard(generatedNumber);
            return existingCardUser == null;
        }
    }
