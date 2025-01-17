package com.poo.aula.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poo.aula.demo.model.Usuario;
import com.poo.aula.demo.model.Visualizacao;

import java.util.List;


@Repository

public interface VisualizacaoRepository extends JpaRepository<Visualizacao, Long> {

    public List<Visualizacao> findByUsuario(Usuario usuario);
    
}

