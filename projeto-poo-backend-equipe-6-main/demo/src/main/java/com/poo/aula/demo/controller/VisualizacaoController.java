package com.poo.aula.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.poo.aula.demo.exception.IdNotFoundException;
import com.poo.aula.demo.model.Visualizacao;
import com.poo.aula.demo.service.VisualizacaoService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value= "api/visualizacao/")
@AllArgsConstructor
public class VisualizacaoController {
    
    @Autowired
    VisualizacaoService visualizacaoService;

    @PostMapping("add/")
    public void insertVisualizacao(@RequestBody Visualizacao visualizacao){
        visualizacaoService.insertVisualizacao(visualizacao);
    }

    @DeleteMapping("delete/{id}/")
    public void deleteVisualizacao(@PathVariable("id") Long id) throws IdNotFoundException {
        try{
            visualizacaoService.deleteById(id);
        }catch(IdNotFoundException e){
            System.out.println("Id não encontrado");
        }
    }

    @GetMapping("all/")
    public List<Visualizacao> getAllVisualizacao(){
        return visualizacaoService.getAllVisualizacao();
    }

    @GetMapping("{id}/")
    public Visualizacao getVisualizacao(@PathVariable("id") Long id) throws IdNotFoundException{
        try{
            return visualizacaoService.getById(id);
        }catch(IdNotFoundException e){
            return null;
        }
    }

}
