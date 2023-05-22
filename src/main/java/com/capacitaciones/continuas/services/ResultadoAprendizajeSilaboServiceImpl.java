package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.Modelos.Primary.ResultadoAprendizajeSilabo;
import com.capacitaciones.continuas.repositorys.Primarys.ResultadosAprendizajeSilaboRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultadoAprendizajeSilaboServiceImpl extends GenericServiceImpl<ResultadoAprendizajeSilabo, Integer> implements ResultadoAprendizajeSilaboService {

    @Autowired
    ResultadosAprendizajeSilaboRepository resultadosAprendizajeSilaboRepository;

    @Override
    public CrudRepository<ResultadoAprendizajeSilabo, Integer> getDao() {
        return resultadosAprendizajeSilaboRepository;
    }

    @Override
    public List<ResultadoAprendizajeSilabo> findBySilaboIdSilabo(Integer idSilabo) {
        return resultadosAprendizajeSilaboRepository.findBySilaboIdSilabo(idSilabo);
    }
}
