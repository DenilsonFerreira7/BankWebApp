package com.bankWebsiteApp.demo.CardConfiguration;

import java.util.Random;

public class CardNumberGenerator {
    Random random = new Random();
    String numeroAleatorio = Integer.toString(random.nextInt(900000000) + 100000000);
    String DigitoAleatorio = Integer.toString(random.nextInt(10));

    String numeroConta = numeroAleatorio + "-" + DigitoAleatorio;
}

