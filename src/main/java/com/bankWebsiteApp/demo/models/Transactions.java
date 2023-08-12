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

@Table(name = "Transactions")
public class Transactions {

    @Id
    @Column(name = "idTransactions")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTransaction;

    @Column(name = "debit")
    private Boolean debit;

    @Column(name = "credit")
    private Boolean credit;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private UserBank accountUserBank;
}