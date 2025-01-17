package com.poo.aula.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poo.aula.demo.model.PlanoGratuito;


@Repository

public interface PlanoGratuitoRepository extends JpaRepository<PlanoGratuito, Long>{
     
    public List<PlanoGratuito> findByNomePlano(String nomePlano);
}
