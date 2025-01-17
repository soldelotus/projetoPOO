package com.poo.aula.demo.controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poo.aula.demo.exception.FilmeNotFoundException;
import com.poo.aula.demo.model.Filme;
import com.poo.aula.demo.service.FilmeService;
 
import lombok.AllArgsConstructor;
 
@RestController
@RequestMapping(value = "/api/filmes/")
@AllArgsConstructor
public class FilmeController {
 
    @Autowired
    FilmeService filmeService;
 
    @GetMapping("all/")
    public List<Filme> getFilmes() {
        return filmeService.getAll();
    }
 
    @GetMapping("{id}/")
    public Filme getFilmeById(@PathVariable("id") Long id) {
        try {
            return filmeService.getById(id);
        } catch (FilmeNotFoundException e) {
            return null;
        }
    }
 
    @PostMapping("add/")
    public void insertFilme(@RequestBody Filme filme) {
        filmeService.insert(filme);
    }
 
    @PutMapping("update/{id}/")
    public void updateFilme(@PathVariable("id") Long id, @RequestBody String newName) {
        try {
            filmeService.updateNameById(id, newName);
        } catch (FilmeNotFoundException e) {
        }
    }
 
    @DeleteMapping("delete/{id}/")
    public void deleteFilmeById(@PathVariable("id") Long id) {
        try {
            filmeService.deleteById(id);
        } catch (FilmeNotFoundException e) {
        }
    }
}
 