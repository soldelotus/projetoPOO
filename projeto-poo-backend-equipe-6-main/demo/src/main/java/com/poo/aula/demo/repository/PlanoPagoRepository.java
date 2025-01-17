package com.poo.aula.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poo.aula.demo.model.PlanoPago;

import java.sql.Date;
import java.util.List;



@Repository

public interface PlanoPagoRepository extends JpaRepository<PlanoPago, Long>{

    public List<PlanoPago> findByNomePlano(String nomePlano);
    public List<PlanoPago> findByDataRenovacaoPlano(Date dataRenovacaoPlano);
}
