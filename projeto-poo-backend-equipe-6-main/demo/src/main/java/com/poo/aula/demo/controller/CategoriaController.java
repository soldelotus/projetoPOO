package com.poo.aula.demo.controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poo.aula.demo.exception.CategoriaNotFoundException;
import com.poo.aula.demo.model.Categoria;
import com.poo.aula.demo.service.CategoriaService;

import lombok.AllArgsConstructor;
 
 
 
 
 
@RestController
@RequestMapping(value= "api/categoria/")
@AllArgsConstructor
public class CategoriaController {
   
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("all/")
    public List<Categoria> getCategorias(){
        return categoriaService.getAllCategoria();
    }
 
    @GetMapping("{id}/")
    public Categoria getCategoriaById(@PathVariable("id") Long id) throws CategoriaNotFoundException{
        try{
            return categoriaService.getById(id);
        }catch(CategoriaNotFoundException e){
            return null;
        }
    }
 
    @PostMapping(value = "add/")
    public void insertCategoria(@RequestBody Categoria categoria) {
        categoriaService.insertCategoria(categoria);
    }
 
    @DeleteMapping("delete/{id}/")
    public void deleteCategoria(@PathVariable("id") Long id) throws CategoriaNotFoundException{
        try{
            categoriaService.deleteById(id);
        }catch(CategoriaNotFoundException e){
            System.out.println("Categoria não existe");
        }
    }
   
   
}
 