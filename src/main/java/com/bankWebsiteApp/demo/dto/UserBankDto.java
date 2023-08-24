package com.bankWebsiteApp.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBankDto {


    private String name;

    private String telephone;

    private Long accountUserBank;
}
