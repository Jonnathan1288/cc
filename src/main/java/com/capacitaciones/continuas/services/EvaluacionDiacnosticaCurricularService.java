package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.Modelos.Primary.EvaluacionDiagnosticaCurricular;

import java.util.List;

public interface EvaluacionDiacnosticaCurricularService extends  GenericService<EvaluacionDiagnosticaCurricular, Integer>{
    List<EvaluacionDiagnosticaCurricular> findByDisenioCurricularIdDisenioCurricular(Integer idCDisenioCurricular);
}
