package com.capacitaciones.continuas.repositorys.Primarys;

import com.capacitaciones.continuas.Modelos.Primary.EvalucionFormativaCurricular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluacionFormativaCurricularRepository extends JpaRepository<EvalucionFormativaCurricular, Integer> {
    List<EvalucionFormativaCurricular> findByDisenioCurricularIdDisenioCurricular(Integer idCDisenioCurricular);
}

