package com.poo.aula.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poo.aula.demo.exception.IdNotFoundException;
import com.poo.aula.demo.model.Portfolio;
import com.poo.aula.demo.repository.PortfolioRepository;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor

public class PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;  

    public void insertPortfolio(Portfolio p){
        portfolioRepository.save(p);  
    }

    public void deleteById(Long id) throws IdNotFoundException {
        Optional <Portfolio> opPortfolio = portfolioRepository.findById(id); 

        if(opPortfolio.isEmpty()){
            throw new IdNotFoundException("Id não encontrado");
        }
        Portfolio p = opPortfolio.get(); 
        portfolioRepository.delete(p);
        portfolioRepository.save(p);
    }

    public List <Portfolio> getAllPortfolio(){
        return portfolioRepository.findAll();     
    }

    public Portfolio getById(Long id) throws IdNotFoundException{
        Optional<Portfolio> opPortfolio = portfolioRepository.findById(id); 

        if(opPortfolio.isEmpty()){
            throw new IdNotFoundException("Id não encontrado.");
        }
        
        return opPortfolio.get(); 
    }


    public void updateById(Long id, Long newId) throws IdNotFoundException{
        Optional<Portfolio> opPortfolio = portfolioRepository.findById(id); 

        if(opPortfolio.isEmpty()){
            throw new IdNotFoundException("Id não encontrado.");
        }

        Portfolio p = opPortfolio.get(); 
        p.setId(newId); 
        portfolioRepository.save(p);
    }


    
  
}

