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

import com.poo.aula.demo.exception.UsuarioNotFoundException;
import com.poo.aula.demo.model.Usuario;
import com.poo.aula.demo.service.UsuarioService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "api/usuarios/")
@AllArgsConstructor

public class UsuarioController {

    @Autowired
    UsuarioService usuarioService; 

    @PostMapping("add/") 
    public void insertUsuario(@RequestBody Usuario usuario){
        usuarioService.insert(usuario);
    }

    @GetMapping("all/")
    public List<Usuario> listarTodosUsuarios(){
        return usuarioService.findAllUsuarios(); 
    }
    
    @GetMapping("{id}/")
    public Usuario getUsuarioById(@PathVariable("id") Long id){
        try{
            return usuarioService.getById(id); 
        } catch(UsuarioNotFoundException e){
            throw new RuntimeException(e.getMessage());   
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Long id){
        try {
            usuarioService.deleteById(id);
        } catch(UsuarioNotFoundException e){
            throw new RuntimeException(e.getMessage()); 
        }
    }

    @GetMapping("/email/{email}") 
    public Usuario buscarUsuariosPorEmail(@PathVariable String email, Usuario usuario){
        try{
            usuarioService.searchEmail(email); 
            return usuario; 
        } catch (UsuarioNotFoundException e){
            throw new RuntimeException(e.getMessage()); 
        }
    }

    @PutMapping("update/{id}/")
    public void updateUsuario(@PathVariable("id") Long id, @RequestBody String novoNome) {
        try {
            usuarioService.updateById(id, novoNome);
        } catch (UsuarioNotFoundException e) {
    }
}

}
