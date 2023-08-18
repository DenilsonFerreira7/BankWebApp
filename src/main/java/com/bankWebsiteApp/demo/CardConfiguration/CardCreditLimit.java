package com.bankWebsiteApp.demo.CardConfiguration;

import java.util.Random;

public class CardCreditLimit {

    public static int generateLimitCredit() {
        Random random = new Random();
        int minPrice = 50;
        int maxPrice = 10000;

        int randomPrice = random.nextInt(maxPrice - minPrice + 1) + minPrice;

        return randomPrice;
    }
}
