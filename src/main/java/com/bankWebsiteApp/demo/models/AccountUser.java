package com.bankWebsiteApp.demo.models;

import com.bankWebsiteApp.demo.CardConfiguration.CardNumberGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity

@Table(name = "AccountUser")
public class AccountUser {

    @Id
    @Column(name = "idAccount")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "numberAccount")
    private String numberAccount;

    @OneToOne
    @JoinColumn(name = "idUser")
    private UserBank accountUserBank;


    // Construtor para preencher automaticamente o número da conta
    public AccountUser(UserBank accountUserBank) {
        this.accountUserBank = accountUserBank;
        this.numberAccount = CardNumberGenerator.generateRandomNumber();
    }
}