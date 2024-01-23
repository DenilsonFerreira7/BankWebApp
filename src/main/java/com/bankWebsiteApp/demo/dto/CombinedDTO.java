package com.bankWebsiteApp.demo.dto;

import com.bankWebsiteApp.demo.models.UserBank;
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
     private int credit;
     private String numberCard;
     private String username;
     private String telephone;
     private String cpf;

}