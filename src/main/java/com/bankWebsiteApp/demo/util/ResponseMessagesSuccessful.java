package com.bankWebsiteApp.demo.util;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ResponseMessagesSuccessful {
    private String message;

    public static ResponseMessagesSuccessful accountCreated(String accountNumber) {
        return new ResponseMessagesSuccessful
                ("Sua nova conta do appBank foi criada o numerodo seu cartão é " + accountNumber);
    }

    public static ResponseMessagesSuccessful userCreated(String userBank) {
        return new ResponseMessagesSuccessful
                ("Seja bem vindo " + userBank + " você acaba de se cadastrar no maior banco do brasil AppBank");
    }

    public static ResponseMessagesSuccessful balanceCreated (int Balance) {
        return new ResponseMessagesSuccessful
                ("Parabéns, você recebeu um limite de credito inicial no valor de  " +Balance+ " $ aproveite !!! ");
    }

    public static ResponseMessagesSuccessful transactionSucess (String Transaction) {
        return new ResponseMessagesSuccessful
                ("Transação feita com sucesso para o beneficiario "+ Transaction);
    }
}
