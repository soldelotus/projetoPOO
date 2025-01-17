package com.poo.aula.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poo.aula.demo.exception.IdNotFoundException;
import com.poo.aula.demo.exception.UsuarioNotFoundException;
import com.poo.aula.demo.model.Usuario;
import com.poo.aula.demo.model.Visualizacao;
import com.poo.aula.demo.repository.VisualizacaoRepository;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor

public class VisualizacaoService {

    @Autowired
    private VisualizacaoRepository visualizacaoRepository;  

    public void insertVisualizacao(Visualizacao v){
        visualizacaoRepository.save(v);  
    }

    public void deleteById(Long id) throws IdNotFoundException{
        Optional <Visualizacao> opVisualizacao = visualizacaoRepository.findById(id);
        
        if(opVisualizacao.isEmpty()){
            throw new IdNotFoundException("Id não encontrado.");
        }

        Visualizacao v = opVisualizacao.get(); 
        visualizacaoRepository.delete(v);
        visualizacaoRepository.save(v);
    }



    public List <Visualizacao> getAllVisualizacao(){
        return visualizacaoRepository.findAll();     
    }

    public Visualizacao getById(Long id) throws IdNotFoundException{
        Optional<Visualizacao> opVisualizacao = visualizacaoRepository.findById(id); 
        
        if(opVisualizacao.isEmpty()){
            throw new IdNotFoundException("Id não encontrado.");
        }

        return opVisualizacao.get(); 
    }


    public void updateById(Long id, Long newId) throws IdNotFoundException{
        Optional<Visualizacao> opVisualizacao = visualizacaoRepository.findById(id); 

        if(opVisualizacao.isEmpty()){
            throw new IdNotFoundException("Id não encontrado.");
        }

        Visualizacao v = opVisualizacao.get(); 
        v.setId(newId); 
        visualizacaoRepository.save(v);
    }
    
    public List<Visualizacao> findByUsuario(Usuario usuario) throws UsuarioNotFoundException{

        List<Visualizacao> visualizacoes = visualizacaoRepository.findByUsuario(usuario);

        if(visualizacoes.isEmpty()){
            throw new UsuarioNotFoundException("Usuário não encontrado.");
        }
        
        return visualizacoes;
    }
  
}

