package com.poo.aula.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poo.aula.demo.exception.PlanoNotFoundException;
import com.poo.aula.demo.model.Plano;
import com.poo.aula.demo.repository.PlanoRepository;

@Service
public class PlanoService {

    
    @Autowired
    private PlanoRepository planoRepository;

    public void insertPlano(Plano p){
        planoRepository.save(p);
    }
    public void deletePlanoById(Long id) throws PlanoNotFoundException{ 
        Optional<Plano> opPlano = planoRepository.findById(id);
        if (opPlano.isEmpty()) {
            throw new PlanoNotFoundException("Plano não encontrado");
        }
        Plano p = opPlano.get();
        planoRepository.save(p);
    }
    public List<Plano> getAllPlano(){
        return planoRepository.findAll();
    }
    public Plano getPlanoById(Long id) throws PlanoNotFoundException{ 
        Optional<Plano> opPlano = planoRepository.findById(id);
        if (opPlano.isEmpty()) {
            throw new PlanoNotFoundException("Plano não encontrado");
        }
        Plano plano = opPlano.get();
        return plano;
    }

    public List<Plano> getPlanosByNome(String nome)throws PlanoNotFoundException{ 
        List<Plano> opPlano = planoRepository.findByNomePlano(nome);
        if (opPlano.isEmpty()) {
            throw new PlanoNotFoundException("Plano não encontrado");
        }
        return planoRepository.findByNomePlano(nome);
    }
}
