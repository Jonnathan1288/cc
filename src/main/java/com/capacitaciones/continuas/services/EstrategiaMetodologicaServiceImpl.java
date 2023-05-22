package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.EstrategiasMetodologica;
import com.capacitaciones.continuas.repositorys.Primarys.EstrategiaMetodologicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstrategiaMetodologicaServiceImpl extends GenericServiceImpl<EstrategiasMetodologica, Integer> implements EstrategiaMetodologicaService {
    @Autowired
    private EstrategiaMetodologicaRepository estrategiaMetodologicaRepository;
    @Override
    public CrudRepository<EstrategiasMetodologica, Integer> getDao() {
        return estrategiaMetodologicaRepository;
    }

    public List<EstrategiasMetodologica> findBySilaboIdSilabo(Integer idSilabo) {
        return estrategiaMetodologicaRepository.findBySilaboIdSilabo(idSilabo);
    }
}
