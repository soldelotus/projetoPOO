package com.poo.aula.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poo.aula.demo.model.Expectador;

@Repository

public interface ExpectadorRepository extends JpaRepository<Expectador, Long>{
    
    public Expectador findByNome(String nome); 

}
