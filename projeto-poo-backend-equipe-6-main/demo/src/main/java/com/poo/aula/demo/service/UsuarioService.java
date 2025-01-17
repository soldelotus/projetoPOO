package com.poo.aula.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poo.aula.demo.exception.UsuarioNotFoundException;
import com.poo.aula.demo.model.Usuario;
import com.poo.aula.demo.repository.UsuarioRepository;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor

public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;  

    
    public void insert(Usuario u){
        usuarioRepository.save(u);  
    }


    public void deleteById(Long id) throws UsuarioNotFoundException{
        Optional <Usuario> opUsuario = usuarioRepository.findById(id); 

        if(opUsuario.isEmpty()){
            throw new UsuarioNotFoundException("Usuário não foi encontrado.");
        }

        Usuario u = opUsuario.get();
        usuarioRepository.delete(u); 
    }


    public List<Usuario> findAllUsuarios() {
        return usuarioRepository.findAll();
    }


    public List <Usuario> getAll(){
        return usuarioRepository.findAll();     
    }


    public Usuario getById(Long id) throws UsuarioNotFoundException{
        Optional<Usuario> opUsuario = usuarioRepository.findById(id); 

        if(opUsuario.isEmpty()){
            throw new UsuarioNotFoundException("Usuário não foi encontrado");
        }
        return opUsuario.get(); 
    }


    public void updateById(Long id, String novoNome) throws UsuarioNotFoundException{
        Optional<Usuario> opUsuario = usuarioRepository.findById(id); 

        if(opUsuario.isEmpty()){
            throw new UsuarioNotFoundException("Usuário " + id + "não foi encontrado.");
        }

        Usuario u = opUsuario.get(); 
        u.setNome(novoNome); 
        usuarioRepository.save(u); 
    }


    public Usuario searchEmail(String email) throws UsuarioNotFoundException{
        Usuario usuario = usuarioRepository.findByEmail(email); 

        if(usuario == null){
            throw new UsuarioNotFoundException("Usuário com" + email + " não foi encontrado.");
        }
        return usuario; 
    }


    
}
