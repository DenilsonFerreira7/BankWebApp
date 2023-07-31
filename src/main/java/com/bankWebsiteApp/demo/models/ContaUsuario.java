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

public class ContaUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conta")
    private Long id;


    @Column(name = "numero_conta")
    private String numeroConta;

    @OneToOne
    @JoinColumn(name = "id_user")
    private  Usuario usuarioConta;

}