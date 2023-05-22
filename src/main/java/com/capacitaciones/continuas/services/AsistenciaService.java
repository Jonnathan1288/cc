package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.Asistencia;

import java.time.LocalDate;
import java.util.List;

public interface AsistenciaService extends  GenericService<Asistencia, Integer>{
    //public Boolean findByFechaAsistencia(LocalDate fecha);

    public Boolean existsByPartipantesMatriculadosInscritoCursoIdCursoAndFechaAsistencia(Integer idCurso, LocalDate fecha);

    public List<Asistencia> findByPartipantesMatriculadosInscritoCursoIdCursoAndFechaAsistencia(Integer idCurso, LocalDate fecha);

}
