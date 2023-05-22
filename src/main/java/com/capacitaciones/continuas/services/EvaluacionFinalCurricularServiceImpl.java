package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.EvaluacionFinalCurricular;
import com.capacitaciones.continuas.repositorys.Primarys.EvaluacionFinalCurricularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluacionFinalCurricularServiceImpl extends GenericServiceImpl<EvaluacionFinalCurricular, Integer> implements EvaluacionFinalCurricularService {
    @Autowired
    private EvaluacionFinalCurricularRepository evaluacionFinalCurricularRepository;
    @Override
    public CrudRepository<EvaluacionFinalCurricular, Integer> getDao() {
        return evaluacionFinalCurricularRepository;
    }

    @Override
    public List<EvaluacionFinalCurricular> findByDisenioCurricularIdDisenioCurricular(Integer idCDisenioCurricular) {
        return evaluacionFinalCurricularRepository.findByDisenioCurricularIdDisenioCurricular(idCDisenioCurricular);
    }
}
