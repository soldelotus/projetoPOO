package com.poo.aula.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poo.aula.demo.exception.UsuarioNotFoundException;
import com.poo.aula.demo.model.Expectador;
import com.poo.aula.demo.repository.ExpectadorRepository;



@Service
public class ExpectadorService {
    
    @Autowired
    private ExpectadorRepository expectadorRepository;  

    public Expectador findByNome(String nome) throws UsuarioNotFoundException{
        Expectador expectador = expectadorRepository.findByNome(nome);

        if(expectador == null){
            throw new UsuarioNotFoundException("Diretor de nome " + nome + " não foi encontrado.");
        }
        return expectador; 
    }


}
