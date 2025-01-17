package com.poo.aula.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.poo.aula.demo.exception.PagamentoInvalidoException;
import com.poo.aula.demo.exception.PagamentoNotFoundException;
import com.poo.aula.demo.model.Pagamento;
import com.poo.aula.demo.service.PagamentoService;


import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping(value="api/pagamento/")
@AllArgsConstructor
public class PagamentoController {
    
    @Autowired
    PagamentoService pagamentoService;

    @GetMapping("all/")
    public List<Pagamento> getAllPagamentos(){
        return pagamentoService.getAllPagamento();
    }

    @GetMapping("{id}/")
    public Pagamento getPagamentoById(@PathVariable("id") Long id) throws PagamentoNotFoundException{
        try{
            return pagamentoService.getById(id);
        }catch(PagamentoNotFoundException e){
            return null;
        }
    }

    @PostMapping("add/")
    public void insertPagamento(@RequestBody Pagamento pagamento){
        pagamentoService.insertPagamento(pagamento);
    }

    @DeleteMapping("{id}/")
    public void deletePagamentoById(@PathVariable ("id") Long id) throws PagamentoNotFoundException{
        try{
            pagamentoService.deleteById(id);
        }catch(PagamentoNotFoundException e){
            
        }
    }

    @PostMapping("/pagar")
    public ResponseEntity<String> pagar(@RequestBody Double preco) {
        try {
            pagamentoService.pagar(preco);
            return ResponseEntity.ok("Pagamento efetuado com sucesso.");
        } catch (PagamentoInvalidoException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
