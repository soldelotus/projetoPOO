package com.poo.aula.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poo.aula.demo.exception.CategoriaNotFoundException;
import com.poo.aula.demo.model.Categoria;
import com.poo.aula.demo.repository.CategoriaRepository;


@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    public void insertCategoria(Categoria c){
        categoriaRepository.save(c);
    }

    public void deleteById(Long id) throws CategoriaNotFoundException{
        Optional<Categoria> opCat = categoriaRepository.findById(id);
        if (opCat.isEmpty()) {
            throw new CategoriaNotFoundException("A categoria informada não existe");
        }
        Categoria c = opCat.get();
        categoriaRepository.delete(c);
    }

    public List<Categoria> getAllCategoria(){
        return categoriaRepository.findAll();
    }

    public Categoria getById(Long id) throws CategoriaNotFoundException{
        Optional<Categoria> opCat = categoriaRepository.findById(id);
        if (opCat.isEmpty()) {
            throw new CategoriaNotFoundException("A categoria informada não existe");
        }
        Categoria categoria = opCat.get();
        return categoria;
    }

    public void upById(Long id, String nomeCategoria)throws CategoriaNotFoundException{
        Optional <Categoria> opCat = categoriaRepository.findById(id);
        if (opCat.isEmpty()) {
            throw new CategoriaNotFoundException("A categoria informada não existe");
        }
        Categoria categoria = opCat.get();
        categoria.setNomeCategoria(nomeCategoria);
        categoriaRepository.save(categoria);
    }

    // public Categoria findByNome(String nomeCategoria) throws CategoriaNotFoundException{
    //     Optional<Categoria> opCategoria = Optional.ofNullable(categoriaRepository.findByNome(nomeCategoria));
    //     if (opCategoria.isEmpty()) {
    //         throw new CategoriaNotFoundException("A categoria informada não existe");
    //     }
    //     Categoria categoria = opCategoria.get();
    //     return categoria;
    // }


}
