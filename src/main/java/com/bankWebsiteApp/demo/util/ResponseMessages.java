package com.bankWebsiteApp.demo.util;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ResponseMessages {
    private String message;

    public static  ResponseMessages accountCreated(String accountNumber){
        return new ResponseMessages("Sua nova conta do appBank foi criada o numerodo seu cartão é " +accountNumber);
    }
}
