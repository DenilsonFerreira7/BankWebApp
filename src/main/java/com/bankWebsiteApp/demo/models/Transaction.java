package com.bankWebsiteApp.demo.models;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity

@Table(name = "Transaction")
public class Transaction {


    @Id
    @Column(name = "idTransaction")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTransaction;

    @ManyToOne
    @JoinColumn(name = "balanceId")
    private Balance balance;

    @Column(name = "transactionType")
    private String transactionType;

    @Column(name = "transactionAmount")
    private Double transactionAmount;

    @Column(name = "beneficiaryNum")
    private String beneficiaryNum;

    @Column(name = "dateTransaction",
            nullable = false, updatable = false, insertable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp dateTransaction;

    @OneToOne
    @JoinColumn(name = "idUser")
    private UserBank accountUserBank;

}
