package com.bankWebsiteApp.demo.cardConfiguration;

import java.util.Random;

public class CardCreditLimit {

    public static double generateLimitCredit() {
        Random random = new Random();
        int minPrice = 50;
        int maxPrice = 10000;

        int randomPrice = random.nextInt(maxPrice - minPrice + 1) + minPrice;

        return randomPrice;
    }
}