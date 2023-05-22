package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.Curso;
import com.capacitaciones.continuas.repositorys.Primarys.CursoRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CursoServiceImpl extends GenericServiceImpl<Curso, Integer> implements CursoService{
    @Autowired
    private CursoRepositry cursoRepositry;
    @Override
    public CrudRepository<Curso, Integer> getDao() {
        return cursoRepositry;
    }

    @Override
    public List<Curso> findByCapacitadorIdCapacitador(Integer idCapacitador) {
        return cursoRepositry.findByCapacitadorUsuarioIdUsuario(idCapacitador);
    }

    @Override
    public List<Curso> findByEstadoCursoAndEstadoPublicasionCurso(boolean estadoCurso) {
        return cursoRepositry.findByEstadoCursoAndEstadoPublicasionCurso(estadoCurso,"V");
    }

    @Override
    public List<Curso> findCursosDelParticipante(Integer idParticipante) {
        return cursoRepositry.findCursosDelParticipante(idParticipante);
    }

}
