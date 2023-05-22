package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.Canton;
import com.capacitaciones.continuas.Modelos.Primary.Capacitador;
import com.capacitaciones.continuas.repositorys.Primarys.CantonRepository;
import com.capacitaciones.continuas.repositorys.Primarys.CapacitadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CantonServiceImpl extends GenericServiceImpl<Canton, Integer> implements CantonService{
    @Autowired
    private CantonRepository cantonRepository;
    @Override
    public CrudRepository<Canton, Integer> getDao() {
        return cantonRepository;
    }


    @Override
    public List<Canton> findByProvinciaIdProvincia(Integer idProvincia) {
        return cantonRepository.findByProvinciaIdProvincia(idProvincia);
    }
}
