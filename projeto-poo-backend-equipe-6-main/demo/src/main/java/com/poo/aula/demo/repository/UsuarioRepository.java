package com.poo.aula.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poo.aula.demo.model.Usuario;


@Repository

public interface UsuarioRepository extends JpaRepository <Usuario, Long> {

    public Usuario findByEmail(String email); 
    
}
