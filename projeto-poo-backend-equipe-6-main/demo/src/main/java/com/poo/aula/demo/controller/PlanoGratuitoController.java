package com.poo.aula.demo.controller;


import com.poo.aula.demo.exception.PlanoNotFoundException;
import com.poo.aula.demo.model.PlanoGratuito;
import com.poo.aula.demo.service.PlanoGratuitoService;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api/planoGratuito/")
@AllArgsConstructor
public class PlanoGratuitoController {

    @Autowired
    private PlanoGratuitoService planoGratuitoService;

    @PostMapping("add/")
     public void insertPlanoGratuito(@RequestBody PlanoGratuito plano){
        planoGratuitoService.insertPlanoGratuito(plano);
    }

  
    @DeleteMapping("/{id}")
    public void deletePlanoGratuito(@PathVariable Long id){
        try {
            planoGratuitoService.deletePlanoGratuitoById(id);
        } catch(PlanoNotFoundException e){
            throw new RuntimeException(e.getMessage()); 
        }
    }

    @GetMapping("all/")
    public List<PlanoGratuito> getAllPlanoPagoGratuito(){
        return planoGratuitoService.getAllPlanoGratuito();
    }

    @GetMapping("{id}/")
    public PlanoGratuito getPlanoById(@PathVariable("id") Long id) throws PlanoNotFoundException{
        try{
            return planoGratuitoService.getPlanoGratuitoById(id);
        }catch(PlanoNotFoundException e){
            return null;
        }
    }

    @GetMapping("nome/{nome}/")
    public List<PlanoGratuito> getPlanosGratuitoByNome(@PathVariable String nome) {
        try{
            return planoGratuitoService.getPlanosByNome(nome);
        }catch(PlanoNotFoundException e){
            return null;
        }
    }
}
