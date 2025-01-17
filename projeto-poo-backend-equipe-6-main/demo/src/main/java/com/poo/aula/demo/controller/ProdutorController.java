package com.poo.aula.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.poo.aula.demo.exception.UsuarioNotFoundException;
import com.poo.aula.demo.model.Produtor;
import com.poo.aula.demo.service.ProdutorService;


@RestController
public class ProdutorController {

    @Autowired
    ProdutorService produtorService; 


    @GetMapping("/produtor/{nome}") 
    public Produtor buscarUsuariosPorNome(@PathVariable String nome){
        Produtor usuario = new Produtor();
        try{
            produtorService.findByNome(nome); 
            return usuario; 
        } catch (UsuarioNotFoundException e){
            throw new RuntimeException(e.getMessage()); 
        }
    }

    
}
