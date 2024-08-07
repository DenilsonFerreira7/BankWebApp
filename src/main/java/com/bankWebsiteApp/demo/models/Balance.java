package com.bankWebsiteApp.demo.models;

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

@Table(name = "Balance")
public class Balance {

    @Id
    @Column(name = "idBalance")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBalance;

    @Column(name = "debit")
    private double debit;

    @Column(name = "credit")
    private double credit;

    @OneToOne
    @JoinColumn(name = "idUser")
    private UserBank accountUserBank;

}