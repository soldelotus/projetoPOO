package com.poo.aula.demo.controller;


import com.poo.aula.demo.exception.DataNotFoundException;
import com.poo.aula.demo.exception.PlanoNotFoundException;
import com.poo.aula.demo.model.PlanoPago;
import com.poo.aula.demo.service.PlanoPagoService;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping(value="api/planoPago/")
@AllArgsConstructor
public class PlanoPagoController {

    @Autowired
    private PlanoPagoService planoPagoService;

    @PostMapping("add/")
     public void insertPlanoPago(@RequestBody PlanoPago plano){
        planoPagoService.insertPlanoPago(plano);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deletePlanoPago(@PathVariable Long id) {
        try {
            planoPagoService.deletePlanoPagoById(id);
            return ResponseEntity.noContent().build();
        } catch (PlanoNotFoundException e) {
            return null;
        }
    }
    @GetMapping("all/")
    public List<PlanoPago> getAllPlanoPago(){
        return planoPagoService.getAllPlanoPago();
    }

    @GetMapping("{id}/")
    public PlanoPago getPlanoPagoaById(@PathVariable("id") Long id) throws PlanoNotFoundException{
        try{
            return planoPagoService.getPlanoPagoById(id);
        }catch(PlanoNotFoundException e){
            return null;
        }
    }

    @GetMapping("nome/{nome}/")
    public List<PlanoPago> getPlanosPagoByNome(@PathVariable String nome) {
        try{
            return planoPagoService.getPlanosByNome(nome);
        }catch(PlanoNotFoundException e){
            return null;
        }
    }

    @GetMapping("renovacao/")
    public List<PlanoPago> getPlanosByDataRenovacao(@RequestParam Date dataRenovacaoPlano) {
        try {
            return planoPagoService.findByDataRenovacaoPlano(dataRenovacaoPlano);
        } catch (DataNotFoundException e) {
            return null;
        }
    }
}

