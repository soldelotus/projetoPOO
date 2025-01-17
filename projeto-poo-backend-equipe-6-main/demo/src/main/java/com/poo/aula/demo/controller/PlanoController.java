package com.poo.aula.demo.controller;


import com.poo.aula.demo.exception.PlanoNotFoundException;
import com.poo.aula.demo.model.Plano;
import com.poo.aula.demo.service.PlanoService;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api/plano/")
@AllArgsConstructor
public class PlanoController {

    @Autowired
    private PlanoService planoService;

    @PostMapping("add/")
     public void insertPlano(@RequestBody Plano plano){
        planoService.insertPlano(plano);
    }

  
    @DeleteMapping("/{id}")
    public void deletePlano(@PathVariable Long id){
        try {
            planoService.deletePlanoById(id);
        } catch(PlanoNotFoundException e){
            throw new RuntimeException(e.getMessage()); 
        }
    }

    @GetMapping("all/")
    public List<Plano> getAllPlanoPago(){
        return planoService.getAllPlano();
    }

    @GetMapping("{id}/")
    public Plano getPlanoById(@PathVariable("id") Long id) throws PlanoNotFoundException{
        try{
            return planoService.getPlanoById(id);
        }catch(PlanoNotFoundException e){
            return null;
        }
    }

    @GetMapping("nome/{nome}/")
    public List<Plano> getPlanosByNome(@PathVariable String nome) {
        try{
            return planoService.getPlanosByNome(nome);
        }catch(PlanoNotFoundException e){
            return null;
        }
    }
}