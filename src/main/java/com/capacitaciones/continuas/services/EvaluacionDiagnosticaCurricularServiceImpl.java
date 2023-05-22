package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.EvaluacionDiagnosticaCurricular;
import com.capacitaciones.continuas.repositorys.Primarys.EvaluacionDiagnosticoCurricularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluacionDiagnosticaCurricularServiceImpl extends GenericServiceImpl<EvaluacionDiagnosticaCurricular, Integer> implements EvaluacionDiacnosticaCurricularService {
    @Autowired
    private EvaluacionDiagnosticoCurricularRepository evaluacionDiagnosticoCurricularRepository;
    @Override
    public CrudRepository<EvaluacionDiagnosticaCurricular, Integer> getDao() {
        return evaluacionDiagnosticoCurricularRepository;
    }

    @Override
    public List<EvaluacionDiagnosticaCurricular> findByDisenioCurricularIdDisenioCurricular(Integer idCDisenioCurricular) {
        return evaluacionDiagnosticoCurricularRepository.findByDisenioCurricularIdDisenioCurricular(idCDisenioCurricular);
    }
}
