package com.poo.aula.demo.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poo.aula.demo.exception.PagamentoInvalidoException;
import com.poo.aula.demo.exception.PagamentoNotFoundException;
import com.poo.aula.demo.model.Pagamento;
import com.poo.aula.demo.model.PlanoPago;
import com.poo.aula.demo.repository.PagamentoRepository;



@Service
public class PagamentoService {
    
    @Autowired
    private PagamentoRepository pagamentoRepository;

    public void insertPagamento(Pagamento p){
        pagamentoRepository.save(p);
    }

    public void deleteById(Long id) throws PagamentoNotFoundException{
        Optional<Pagamento> opPagamento = pagamentoRepository.findById(id);
        if (opPagamento.isEmpty()) {
            throw new PagamentoNotFoundException("O pagamento não encontrado");
        }
        Pagamento p = opPagamento.get();
        pagamentoRepository.save(p);
    }

    public List<Pagamento> getAllPagamento(){
        return pagamentoRepository.findAll();
    }

    public Pagamento getById(Long id) throws PagamentoNotFoundException{
        Optional<Pagamento> opPagamento = pagamentoRepository.findById(id);
        if (opPagamento.isEmpty()) {
            throw new PagamentoNotFoundException("O pagamento não encontrado");
        }
        Pagamento pagamento = opPagamento.get();
        return pagamento;
    }

    public void updateById(Long id, String tipoPagamento) throws PagamentoNotFoundException{
        Optional<Pagamento> opPagamento = pagamentoRepository.findById(id);
        if (opPagamento.isEmpty()) {
            throw new PagamentoNotFoundException("O pagamento não encontrado");
        }
        Pagamento pagamento = opPagamento.get();
        pagamento.setTipoPagamento(tipoPagamento);
        pagamentoRepository.save(pagamento);
    }

    public void pagar(Double preco) throws PagamentoInvalidoException{
        PlanoPago plano = new PlanoPago();
        if(preco.equals(plano.getPreco())){
            plano.setPreco(preco);
        }else{
            throw new PagamentoInvalidoException("Não foi possível efetuar o pagamento");
        }
    }

    
}

