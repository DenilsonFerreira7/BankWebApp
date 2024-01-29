package com.bankWebsiteApp.demo.models;
import com.bankWebsiteApp.demo.CardConfiguration.CardNumberGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity

@Table(name = "CardUser")
public class CardUser {

    @Id
    @Column(name = "idCard")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCard;

    @Column(name = "numberCard")
    private String numberCard;

    @NotNull
    @Column (name = "passwordCard")
    private String passwordCard;

    @OneToOne
    @JoinColumn(name = "idUser")
    private UserBank accountUserBank;

    // Construtor para preencher automaticamente o número da conta
    public CardUser(UserBank accountUserBank) {
        this.accountUserBank = accountUserBank;
        this.numberCard = CardNumberGenerator.generateMastercardNumber();
    }
}