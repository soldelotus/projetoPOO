package com.poo.aula.demo.service;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import com.poo.aula.demo.exception.PlanoNotFoundException;
import com.poo.aula.demo.exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poo.aula.demo.model.PlanoPago;
import com.poo.aula.demo.repository.PlanoPagoRepository;

@Service
public class PlanoPagoService {

    
    @Autowired
    private PlanoPagoRepository planoPagoRepository;

    public void insertPlanoPago(PlanoPago p){
        planoPagoRepository.save(p);
    }
    public void deletePlanoPagoById(Long id) throws PlanoNotFoundException{
        Optional<PlanoPago> opPlanoPago = planoPagoRepository.findById(id);
        if (opPlanoPago.isEmpty()) {
            throw new PlanoNotFoundException("Plano não encontrado");
        }
        PlanoPago p = opPlanoPago.get();
        planoPagoRepository.save(p);
    }
    public List<PlanoPago> getAllPlanoPago(){
        return planoPagoRepository.findAll();
    }
    public PlanoPago getPlanoPagoById(Long id) throws PlanoNotFoundException{
        Optional<PlanoPago> opPlanoPago = planoPagoRepository.findById(id);
        if (opPlanoPago.isEmpty()) {
            throw new PlanoNotFoundException("Plano não encontrado");
        }
        PlanoPago planoPago = opPlanoPago.get();
        return planoPago;
    }
    public List<PlanoPago> getPlanosByNome(String nome) throws PlanoNotFoundException {
        List<PlanoPago> opPlanoPago = planoPagoRepository.findByNomePlano(nome);
        if (opPlanoPago.isEmpty()) {
            throw new PlanoNotFoundException("Plano não encontrado");
        }
        return planoPagoRepository.findByNomePlano(nome);
    }

    public List<PlanoPago> findByDataRenovacaoPlano(Date dataRenovacaoPlano) throws DataNotFoundException{
        if (dataRenovacaoPlano == null) {
            throw new DataNotFoundException("A data de renovação fornecida é nula.");
        }
        return planoPagoRepository.findByDataRenovacaoPlano(dataRenovacaoPlano);
    }
    
    public List<PlanoPago> renovarPlanoPago(Date dataAtual, Double preco) throws PlanoNotFoundException{    
    List<PlanoPago> planosParaRenovar = planoPagoRepository.findByDataRenovacaoPlano(dataAtual);
        if (planosParaRenovar.isEmpty()) {
            throw new PlanoNotFoundException("Nenhum plano encontrado para renovação na data: " + dataAtual);
        }
        for (int i = 0; i < planosParaRenovar.size(); i++) {
            PlanoPago plano = planosParaRenovar.get(i);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(plano.getDataRenovacaoPlano());
            calendar.add(Calendar.MONTH, 1); 

            plano.setDataRenovacaoPlano(new Date(calendar.getTimeInMillis()));
            plano.setPreco(preco);
        }
        planoPagoRepository.saveAll(planosParaRenovar);
        return planosParaRenovar;
    }
}
