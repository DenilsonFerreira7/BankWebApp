package com.bankWebsiteApp.demo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity

@Table(name = "UserBank")
public class UserBank {

    @Id
    @Column(name = "idUser")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @NotNull
    @NotBlank
    @Column(name = "nameUser")
    private String name;

    @NotNull
    @NotBlank
    @Column(name = "cpfUser")
    private String cpfUser;

    @NotNull
    @NotBlank
    @Column(name = "passwordUser")
    private String passwordUser;

    @NotNull
    @NotBlank
    @Column(name = "emailUser")
    private String emailUser;

    @NotNull
    @NotBlank
    @Column(name = "telephoneUser")
    private String telephone;


    public String getPassword() {
        return passwordUser;
    }


}