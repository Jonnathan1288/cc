package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.Modelos.Primary.Curso;
import com.capacitaciones.continuas.Modelos.Primary.Notas;
import com.capacitaciones.continuas.repositorys.Primarys.NotasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotasSeviceImpl extends GenericServiceImpl<Notas, Integer> implements NotasSevice {

    @Autowired
    NotasRepository notasRepository;

    @Override
    public CrudRepository<Notas, Integer> getDao() {
        return notasRepository;
    }

    @Override
    public List<Notas> findByPartipantesMatriculadosInscritoCursoIdCurso(Integer idCurso) {
        return notasRepository.findByPartipantesMatriculadosInscritoCursoIdCurso(idCurso);
    }

    @Override
    public List<Notas> findByPartipantesMatriculadosIdParticipanteMatriculado(Integer idParticipantesFinales) {
        return notasRepository.findByPartipantesMatriculadosIdParticipanteMatriculado(idParticipantesFinales);
    }

    @Override
    public Boolean validarExistenciaDeRegistroNotas(Integer idCurso) {
        List<Notas> cursos = notasRepository.findByPartipantesMatriculadosInscritoCursoIdCurso(idCurso);
        if (cursos == null || cursos.isEmpty()) {
            return true;
        }else {
            return false;
        }
    }
}