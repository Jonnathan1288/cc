package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.Modelos.Primary.HorarioCurso;
import com.capacitaciones.continuas.repositorys.Primarys.HorarioCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class HorarioCursoServiceImpl extends GenericServiceImpl<HorarioCurso, Integer> implements HorarioCursoService {

    @Autowired
    HorarioCursoRepository horarioCursoRepository;

    @Override
    public CrudRepository<HorarioCurso, Integer> getDao() {
        return horarioCursoRepository;
    }

}
