package com.bankWebsiteApp.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CombinedDto {
     private UserBankDto userBankDto;
     private BalanceDto balanceDto;
     private CardUserDto cardUserDto;

}
