package com.poo.aula.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poo.aula.demo.exception.UsuarioNotFoundException;
import com.poo.aula.demo.model.Produtor;
import com.poo.aula.demo.repository.ProdutorRepository;



@Service
public class ProdutorService {

    @Autowired
    private ProdutorRepository produtorRepository;  

    public Produtor findByNome(String nome) throws UsuarioNotFoundException{
        Produtor produtor = produtorRepository.findByNome(nome);

        if(produtor == null){
            throw new UsuarioNotFoundException("Diretor de nome " + nome + " não foi encontrado.");
        }
        return produtor; 
    }

}
