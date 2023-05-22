package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.Modelos.Secondary.DocenteFenix;
import com.capacitaciones.continuas.repositorys.Secondary.DocenteFenixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class DocenteFenixServiceImpl extends GenericServiceImpl<DocenteFenix, Integer> implements DocenteFenixService {

    @Autowired
    private DocenteFenixRepository docenteFenixRepository;

    @Override
    public CrudRepository<DocenteFenix, Integer> getDao() {
        return docenteFenixRepository;
    }

    @Override
    public DocenteFenix findByAndIdentificacion(String identificasion) {
        return docenteFenixRepository.findByAndIdentificacion(identificasion);
    }
}

