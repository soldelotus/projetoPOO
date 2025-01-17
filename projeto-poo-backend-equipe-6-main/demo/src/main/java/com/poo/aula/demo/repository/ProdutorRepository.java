package com.poo.aula.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poo.aula.demo.model.Produtor;

@Repository
public interface ProdutorRepository extends JpaRepository<Produtor, Long> {

    public Produtor findByNome(String nome); 
    
}
