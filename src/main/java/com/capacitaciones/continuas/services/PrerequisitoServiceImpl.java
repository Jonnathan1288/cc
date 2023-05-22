package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.Modelos.Primary.PrerequisitoCurso;
import com.capacitaciones.continuas.repositorys.Primarys.PrerequisitoCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrerequisitoServiceImpl extends GenericServiceImpl<PrerequisitoCurso, Integer> implements PrerequisitoCursoService {

    @Autowired
    private PrerequisitoCursoRepository prerequisitoCursoRepository;

    @Override
    public CrudRepository<PrerequisitoCurso, Integer> getDao() {
        return prerequisitoCursoRepository;
    }

    @Override
    public List<PrerequisitoCurso> findByCursoIdCurso(Integer idCurso) {
        return prerequisitoCursoRepository.findByCursoIdCurso(idCurso);
    }
}
