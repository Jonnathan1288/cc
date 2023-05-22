package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.Modelos.Primary.NecesidadCurso;
import com.capacitaciones.continuas.repositorys.Primarys.NecesidadCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class NecesidadCursoServiceImpl extends GenericServiceImpl<NecesidadCurso, Integer> implements NecesidadCursoService {

    @Autowired
    NecesidadCursoRepository necesidadCursoRepository;

    @Override
    public CrudRepository<NecesidadCurso, Integer> getDao() {
        return necesidadCursoRepository;
    }

    @Override
    public NecesidadCurso findByCursoIdCurso(Integer idCurso) {
        return necesidadCursoRepository.findByCursoIdCurso(idCurso);
    }
}