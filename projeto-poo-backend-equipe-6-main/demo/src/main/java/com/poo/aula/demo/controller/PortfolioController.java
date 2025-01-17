package com.poo.aula.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.poo.aula.demo.exception.IdNotFoundException;
import com.poo.aula.demo.model.Portfolio;
import com.poo.aula.demo.service.PortfolioService;

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
@RequestMapping(value= "api/portfolio/")
@AllArgsConstructor
public class PortfolioController {
    
    @Autowired
    PortfolioService portfolioService;

    @PostMapping("add/")
    public void insertPortfolio(@RequestBody Portfolio portfolio){
        portfolioService.insertPortfolio(portfolio);
    }
    
    @DeleteMapping("delete/{id}/")
    public void deletePortfolio(@PathVariable("id") Long id) throws IdNotFoundException {
        try{
            portfolioService.deleteById(id);
            }catch(IdNotFoundException e)
            {
                System.out.println("Id não encontrado");
            }
        }
    
    @GetMapping("all/")
    public List<Portfolio> getAllPortfolio(){
        return portfolioService.getAllPortfolio();
    }

    @GetMapping("{id}/")
    public Portfolio getPortfolioById(@PathVariable("id") Long id) throws IdNotFoundException{
        try{
            return portfolioService.getById(id);
        }catch(IdNotFoundException e){
            return null;
        }
    }


}
