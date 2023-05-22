package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.Notas;

import java.util.List;

public interface NotasSevice extends GenericService<Notas, Integer>{

    List<Notas> findByPartipantesMatriculadosInscritoCursoIdCurso(Integer idCurso);

    List<Notas> findByPartipantesMatriculadosIdParticipanteMatriculado(Integer idParticipantesFinales);

    Boolean validarExistenciaDeRegistroNotas(Integer idCurso);

}
