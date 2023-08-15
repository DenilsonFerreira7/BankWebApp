package com.bankWebsiteApp.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountUserDto implements Serializable {

    private String numberAccount;

    private Long accountUserBank;

}
