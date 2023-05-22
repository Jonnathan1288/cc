package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.ContenidoSilabo;
import com.capacitaciones.continuas.repositorys.Primarys.ContenidoSilaboRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContenidoSilaboServiceImpl extends GenericServiceImpl<ContenidoSilabo, Integer> implements ContenidoSilaboService{
    @Autowired
    private ContenidoSilaboRepository contenidoSilaboRepository;
    @Override
    public CrudRepository<ContenidoSilabo, Integer> getDao() {
        return contenidoSilaboRepository;
    }

    @Override
    public List<ContenidoSilabo> findBySilaboIdSilabo(Integer idSilabo) {
        return contenidoSilaboRepository.findBySilaboIdSilabo(idSilabo);
    }
}
