package com.bankWebsiteApp.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class BalanceDTO implements Serializable {

    private double debit;
    private double credit;
    private Long accountUserBank;

}
