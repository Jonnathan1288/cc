package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.Asistencia;
import com.capacitaciones.continuas.repositorys.Primarys.AsistenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AsistenciaServiceImpl extends GenericServiceImpl<Asistencia, Integer> implements AsistenciaService{
    @Autowired
    private AsistenciaRepository asistenciaRepository;
    @Override
    public CrudRepository<Asistencia, Integer> getDao() {
        return asistenciaRepository;
    }

    /*@Override
    public Boolean findByFechaAsistencia(LocalDate fecha) {
        return asistenciaRepository.existsByFechaAsistencia(fecha);
    }*/

    @Override
    public Boolean existsByPartipantesMatriculadosInscritoCursoIdCursoAndFechaAsistencia(Integer idCurso, LocalDate fecha) {
        return asistenciaRepository.existsByPartipantesMatriculadosInscritoCursoIdCursoAndFechaAsistencia(idCurso, fecha);
    }

    @Override
    public List<Asistencia> findByPartipantesMatriculadosInscritoCursoIdCursoAndFechaAsistencia(Integer idCurso, LocalDate fecha) {
        return asistenciaRepository.findByPartipantesMatriculadosInscritoCursoIdCursoAndFechaAsistencia(idCurso, fecha);
    }


}
