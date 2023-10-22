package com.bankWebsiteApp.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CombinedDto {
     private UserBankDto userBankDto;
     private BalanceDto balanceDto;
     private CardUserDto cardUserDto;

}
