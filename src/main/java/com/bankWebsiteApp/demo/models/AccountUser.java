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

}