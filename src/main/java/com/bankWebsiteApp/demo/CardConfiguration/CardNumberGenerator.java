package com.bankWebsiteApp.demo.CardConfiguration;

import org.springframework.stereotype.Component;

import java.util.Random;
@Component
public class CardNumberGenerator {

    private static long counter = 5555555555554444L; // Iniciar a partir de um número de exemplo

    public static String generateMastercardNumber() {
        String generatedNumber = String.valueOf(counter);
        String digit = String.valueOf(calculateLuhnDigit(generatedNumber));
        counter++; // Incrementar o contador para o próximo número

        return generatedNumber + digit;
    }

    public static void resetCounter() {
        counter = 5555555555554444L; // Reiniciar o contador se necessário
    }

    private static int calculateLuhnDigit(String number) {
        int sum = 0;
        boolean alternate = false;

        for (int i = number.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(number.charAt(i));

            if (alternate) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }

            sum += digit;
            alternate = !alternate;
        }

        return (sum % 10 == 0) ? 0 : (10 - (sum % 10));
    }
}