package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.PeriodoPrograma;
import com.capacitaciones.continuas.repositorys.Primarys.PeriodoProgramaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PeriodoProgramaServiceImpl extends GenericServiceImpl<PeriodoPrograma, Integer> implements PeriodoProgramaService {

    @Autowired
    private PeriodoProgramaRepository periodoProgramaRepository;

    @Override
    public CrudRepository<PeriodoPrograma, Integer> getDao() {
        return periodoProgramaRepository;
    }
}
