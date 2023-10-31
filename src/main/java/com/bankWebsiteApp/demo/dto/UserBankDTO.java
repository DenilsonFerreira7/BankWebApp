package com.bankWebsiteApp.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UserBankDTO {

    private Long idUser;
    private String name;
    private String telephone;
    private String emailUser;
    private String cpfUser;

}
