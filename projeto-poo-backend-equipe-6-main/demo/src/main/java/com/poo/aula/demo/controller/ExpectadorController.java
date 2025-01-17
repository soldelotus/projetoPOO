package com.poo.aula.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.poo.aula.demo.exception.UsuarioNotFoundException;
import com.poo.aula.demo.model.Usuario;
import com.poo.aula.demo.service.ExpectadorService;


import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class ExpectadorController {
    
    @Autowired
    ExpectadorService expectadorService; 


        @GetMapping("/nome/{nome}") 
    public Usuario buscarUsuariosPorEmail(@PathVariable String nome, Usuario usuario){
        try{
            expectadorService.findByNome(nome); 
            return usuario; 
        } catch (UsuarioNotFoundException e){
            throw new RuntimeException(e.getMessage()); 
        }
    }
    
}
