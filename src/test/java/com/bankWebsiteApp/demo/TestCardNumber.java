//package com.bankWebsiteApp.demo;
//
//import com.bankWebsiteApp.demo.CardConfiguration.CardNumberGenerator;
//import com.bankWebsiteApp.demo.repository.CardUserRepository;
//import com.bankWebsiteApp.demo.validation.CardNumberValidation;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//
//import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.when;
//
//public class TestCardNumber {
//
//    private CardNumberValidation cardNumberValidationService;
//    private CardUserRepository cardUserRepository;
//
//    @Test
//    public void testGenerateUniqueCardNumber() {
//        // Criando um mock para CardUserRepository
//        CardUserRepository cardUserRepository = Mockito.mock(CardUserRepository.class);
//        CardNumberGenerator cardNumberGenerator = new CardNumberGenerator();
//        CardNumberValidation cardNumberValidation = new CardNumberValidation(cardUserRepository, cardNumberGenerator);
//
//        // Simulando que não há nenhum CardUser existente com o número gerado
//        when(cardUserRepository.findByNumberCard(anyString())).thenReturn(null);
//
//        // Testando a geração de um número de cartão único
//        assertDoesNotThrow(() -> {
//            String uniqueCardNumber = cardNumberValidation.generateUniqueCardNumber();
//            assertNotNull(uniqueCardNumber);
//            System.out.println("Generated Unique Card Number: " + uniqueCardNumber);
//        });
//    }
//}