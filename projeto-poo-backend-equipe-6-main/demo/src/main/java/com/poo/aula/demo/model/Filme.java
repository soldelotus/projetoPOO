package com.poo.aula.demo.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @Column(length = 50, nullable = false)
    private String nomeFilme; 

    @Column(length = 45, nullable = false)
    private String diretor; 

    @Column
    private String duracao; 

    @Column
    private Short notaAvaliacao; 

    @Column(length = 500)
    private String sinopse;

    // @Column
    // private List<Categoria> tipoDeCategoria; 

    // @Column(length = 40)
    // private Usuario usuario; 

    // @Column 
    // private Visualizacao visualizacao; 

    @Column
    private String link; 

    @ManyToMany
    @JoinTable(
        name = "filmeCategoria",
        joinColumns = @JoinColumn(name = "filme_id"),
        inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    @JsonIgnore
    private List<Categoria> tipoDeCategoria; 

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonIgnore
    private Usuario usuario; 

    @OneToOne
    @JoinColumn(name = "visualizacao_id")
    @JsonIgnore
    private Visualizacao visualizacao;

}


