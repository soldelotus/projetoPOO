package com.poo.aula.demo.repository;
 
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import com.poo.aula.demo.model.Filme;
 
@Repository
 
public interface FilmeRepository extends JpaRepository<Filme, Long>{
 
   
    // public Filme findByNome(String nomeFilme);
    // public Filme findByDiretor(String diretor);
     
 
   
}
 