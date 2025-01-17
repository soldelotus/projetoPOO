package com.poo.aula.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
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
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id; 

    @Column(length = 45, nullable = false)
    private String nome; 

    @Column(length = 40, nullable = false)
    private String email; 

    @OneToOne(mappedBy = "usuario")
    @JsonIgnore
    private Plano tipoPlano; 

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Filme> filmesQueroAssistir;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Filme> filmesBaixados;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Filme> filmes;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Visualizacao> historicoDeFilmes;

    @OneToOne(mappedBy = "usuario")
    @JsonIgnore
    private Filme filmeFavoritado;

}
