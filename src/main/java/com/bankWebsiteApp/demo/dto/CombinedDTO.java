package com.bankWebsiteApp.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CombinedDTO {
     private UserBankDTO userBankDto;
     private BalanceDTO balanceDto;
     private CardUserDTO cardUserDto;

}
