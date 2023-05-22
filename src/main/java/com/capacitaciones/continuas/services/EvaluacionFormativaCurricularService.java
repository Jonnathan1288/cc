package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.Modelos.Primary.EvalucionFormativaCurricular;

import java.util.List;

public interface EvaluacionFormativaCurricularService extends  GenericService<EvalucionFormativaCurricular, Integer>{
    List<EvalucionFormativaCurricular> findByDisenioCurricularIdDisenioCurricular(Integer idDisenioCurricular);
}
