package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.Modelos.Primary.InformeFinalCurso;
import com.capacitaciones.continuas.Modelos.Primary.Inscrito;
import com.capacitaciones.continuas.repositorys.Primarys.InformeFinalCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformeFinalCursoServiceImpl extends GenericServiceImpl<InformeFinalCurso, Integer> implements InformeFinalCursoService {

    @Autowired
    InformeFinalCursoRepository informeFinalCursoRepository;

    @Override
    public CrudRepository<InformeFinalCurso, Integer> getDao() {
        return informeFinalCursoRepository;
    }

    @Override
    public InformeFinalCurso findByCursoIdCurso(Integer idCurso) {
        return informeFinalCursoRepository.findByCursoIdCurso(idCurso);
    }

}

