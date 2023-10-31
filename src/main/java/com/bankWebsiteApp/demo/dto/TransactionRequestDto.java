package com.bankWebsiteApp.demo.dto;

import com.bankWebsiteApp.demo.models.Balance;
import com.bankWebsiteApp.demo.models.UserBank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionRequestDto {

    private UserBank idUser;
    private Balance idBalance;
    private CardUserDTO cardUser;
    private String transactionType;
    private Double transactionAmount;
    private String beneficiaryNum;
}
