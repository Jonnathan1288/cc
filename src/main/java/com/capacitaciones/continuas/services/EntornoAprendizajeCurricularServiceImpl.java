package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.EntornoAprendizajeCurricular;
import com.capacitaciones.continuas.repositorys.Primarys.EntornoAprendizajeCurricularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntornoAprendizajeCurricularServiceImpl extends GenericServiceImpl<EntornoAprendizajeCurricular, Integer> implements EntornoAprendizajeCurricularService {
    @Autowired
    private EntornoAprendizajeCurricularRepository entornoAprendizajeCurricularRepository;
    @Override
    public CrudRepository<EntornoAprendizajeCurricular, Integer> getDao() {
        return entornoAprendizajeCurricularRepository;
    }

    @Override
    public List<EntornoAprendizajeCurricular> findByDisenioCurricularIdDisenioCurricular(Integer idCDisenioCurricular) {
        return entornoAprendizajeCurricularRepository.findByDisenioCurricularIdDisenioCurricular(idCDisenioCurricular);
    }
}
