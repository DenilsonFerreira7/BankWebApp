package com.bankWebsiteApp.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BalanceDto implements Serializable {

    private double debit;

    private int credit;

    private Long accountUserBank;

}
