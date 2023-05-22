package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.Modelos.Primary.Notas;
import com.capacitaciones.continuas.Modelos.Primary.Parroquia;
import com.capacitaciones.continuas.repositorys.Primarys.NotasRepository;
import com.capacitaciones.continuas.repositorys.Primarys.ParroquiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParroquiaSeviceImpl extends GenericServiceImpl<Parroquia, Integer> implements ParroquiaService {

    @Autowired
    private ParroquiaRepository parroquiaRepository;

    @Override
    public CrudRepository<Parroquia, Integer> getDao() {
        return parroquiaRepository;
    }


    @Override
    public List<Parroquia> findByCanton_IdCanton(Integer idCanton) {
        return parroquiaRepository.findByCanton_IdCanton(idCanton);
    }
}