package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.Modelos.Primary.RegistroFotograficoCurso;
import com.capacitaciones.continuas.repositorys.Primarys.RegistroFotograficoCurosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroFotograficoCursoServiceImpl extends GenericServiceImpl<RegistroFotograficoCurso, Integer> implements RegistroFotograficoCursoService {

    @Autowired
    RegistroFotograficoCurosRepository registroFotograficoCurosRepository;

    @Override
    public CrudRepository<RegistroFotograficoCurso, Integer> getDao() {
        return registroFotograficoCurosRepository;
    }

    @Override
    public List<RegistroFotograficoCurso> findByCursoIdCurso(Integer idCurso) {
        return registroFotograficoCurosRepository.findByCursoIdCurso(idCurso);
    }
}