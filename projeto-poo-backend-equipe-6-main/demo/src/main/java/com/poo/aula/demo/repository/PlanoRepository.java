package com.poo.aula.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poo.aula.demo.model.Plano;



@Repository

public interface PlanoRepository extends JpaRepository<Plano, Long>{
    
     public List<Plano> findByNomePlano(String nomePlano);
    
}
