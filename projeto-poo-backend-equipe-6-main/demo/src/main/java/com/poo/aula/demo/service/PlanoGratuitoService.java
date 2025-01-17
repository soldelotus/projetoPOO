package com.poo.aula.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poo.aula.demo.exception.PlanoNotFoundException;
import com.poo.aula.demo.model.PlanoGratuito;
import com.poo.aula.demo.repository.PlanoGratuitoRepository;

@Service
public class PlanoGratuitoService {
    
    @Autowired
    private PlanoGratuitoRepository planoGratuitoRepository;

    public void insertPlanoGratuito(PlanoGratuito p){
        planoGratuitoRepository.save(p);
    }
    public void deletePlanoGratuitoById(Long id)throws PlanoNotFoundException{ 
        Optional<PlanoGratuito> opPlanoGratuito = planoGratuitoRepository.findById(id);
        if (opPlanoGratuito.isEmpty()) {
            throw new PlanoNotFoundException("Plano não encontrado");
        }
        PlanoGratuito p = opPlanoGratuito.get();
        planoGratuitoRepository.save(p);
    }
    public List<PlanoGratuito> getAllPlanoGratuito(){
        return planoGratuitoRepository.findAll();
    }
    public PlanoGratuito getPlanoGratuitoById(Long id)throws PlanoNotFoundException{ 
        Optional<PlanoGratuito> opPlanoGratuito = planoGratuitoRepository.findById(id);
        if (opPlanoGratuito.isEmpty()) {
        }
        PlanoGratuito planoGratuito = opPlanoGratuito.get();
        return planoGratuito;
    }
    public List<PlanoGratuito> getPlanosByNome(String nome) throws PlanoNotFoundException{ 
        List<PlanoGratuito> opPlanoGratuito = planoGratuitoRepository.findByNomePlano(nome);
        if (opPlanoGratuito.isEmpty()) {
        }
        return planoGratuitoRepository.findByNomePlano(nome);
    }
}
