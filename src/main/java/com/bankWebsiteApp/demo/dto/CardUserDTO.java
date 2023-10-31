package com.bankWebsiteApp.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardUserDTO implements Serializable {

    private String numberCard;
    private String passwordCard;

    public static CardUserDTO findByNumberCard(String numberCard) {
        return CardUserDTO.builder().numberCard(numberCard).build();
    }

    public String getNumberCard() {
        return this.numberCard;
    }

    public String getPasswordCard() {
        return this.passwordCard;
    }
}
