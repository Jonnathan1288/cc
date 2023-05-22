package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.Modelos.Primary.ParticipantesAprobados;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ParticipantesAprobadosService extends GenericService<ParticipantesAprobados, Integer>{
    public List<ParticipantesAprobados> findByPartipantesMatriculadosInscritoCursoIdCurso(Integer idCurso);

    public boolean existsByPartipantesMatriculadosInscritoCursoIdCurso(Integer idCurso);

    public ParticipantesAprobados findByCursoAndUsuario(Integer idCurso, String ci);


}
