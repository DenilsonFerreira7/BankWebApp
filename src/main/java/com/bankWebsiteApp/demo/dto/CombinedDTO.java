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

     private Long userId;
     private double debit;
     private double credit;
     private String numberCard;
     private String username;
     private String telephone;
     private String cpf;

}