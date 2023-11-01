package com.bankWebsiteApp.demo.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MessageNotFoundException extends RuntimeException {

    public MessageNotFoundException(String message) {
        super(message);

    }

    public static MessageNotFoundException NotFoundUserId(Long id) {
        return new MessageNotFoundException("Usuario com id " + id + " Não encontrado");
    }

    public static MessageNotFoundException NotFoundCardNumber(String cardNumber) {
        return new MessageNotFoundException("Cartão com número " + cardNumber + " Não encontrado");
    }

    public static MessageNotFoundException NotFoundCardPassword(String cardNumber) {
        return new MessageNotFoundException("Senha do cartão " + cardNumber + " invalido");
    }

}