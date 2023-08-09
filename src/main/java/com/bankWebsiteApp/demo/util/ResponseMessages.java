package com.bankWebsiteApp.demo.util;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ResponseMessages {
    private String message;

    public static ResponseMessages accountCreated(String accountNumber) {
        return new ResponseMessages("Sua nova conta do appBank foi criada o numerodo seu cartão é " + accountNumber);
    }

    public static ResponseMessages userCreated(String userBank) {
        return new ResponseMessages("Seja bem vindo " + userBank + " você acaba de se cadastrar no maior banco do brasil AppBank");
    }
}
