package com.poo.aula.demo.service;
 
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.poo.aula.demo.exception.FilmeNotFoundException;
import com.poo.aula.demo.model.Filme;
import com.poo.aula.demo.repository.FilmeRepository;
 
import lombok.AllArgsConstructor;
 
@Service
@AllArgsConstructor
public class FilmeService {
 
    @Autowired
    private FilmeRepository filmeRepository;
 
    public void insert(Filme filme) {
        filmeRepository.save(filme);
    }
 
    public Filme getById(Long id) throws FilmeNotFoundException {
        Optional<Filme> opFilme = filmeRepository.findById(id);
 
        if (opFilme.isEmpty()) {
            throw new FilmeNotFoundException("Filme não encontrado.");
        }
 
        return opFilme.get();
    }
 
    public List<Filme> getAll() {
        return filmeRepository.findAll();
    }
 
    public void delete(Filme filme) {
        filmeRepository.delete(filme);
    }
 
    public void deleteById(Long id) throws FilmeNotFoundException {
        Optional<Filme> opFilme = filmeRepository.findById(id);
 
        if (opFilme.isEmpty()) {
            throw new FilmeNotFoundException("Filme não encontrado.");
        }
 
        Filme filme = opFilme.get();
        filmeRepository.delete(filme);
    }
 
    public void updateNameById(Long id, String nomeFilme) throws FilmeNotFoundException {
        Optional<Filme> opFilme = filmeRepository.findById(id);
 
        if (opFilme.isEmpty()) {
            throw new FilmeNotFoundException("Filme não encontrado.");
        }
 
        Filme filme = opFilme.get();
        filme.setNomeFilme(nomeFilme);
        filmeRepository.save(filme);
    }
 
    // public Filme findByNome(String nomeFilme) throws FilmeNotFoundException {
    //     Filme filme = filmeRepository.findByNome(nomeFilme);
 
    //     if (filme == null) {
    //         throw new FilmeNotFoundException("Filme não encontrado.");
    //     }
 
    //     return filme;
    // }
 
    // public Filme searchByDiretor(String diretor) throws FilmeNotFoundException {
    //     Filme filme = filmeRepository.findByDiretor(diretor);
 
    //     if (filme == null) {
    //         throw new FilmeNotFoundException("Filme não encontrado.");
    //     }
 
    //     return filme;
    // }
}
 