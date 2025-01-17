package com.poo.aula.demo.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@SuperBuilder
public class Plano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nomePlano;

    @Column
    private Double preco;

    @Column
    private Date dataInicioPlano;

    @Column
    private Date dataTerminoPlano;

    @OneToOne
    @JoinColumn(name = "plano_id")
    @JsonIgnore
    private Pagamento pagamento;

    @OneToOne
    @JoinColumn(name = "tipoPlano_id")
    @JsonIgnore
    private Usuario usuario;
}
