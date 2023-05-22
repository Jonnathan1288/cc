package com.capacitaciones.continuas.repositorys.Primarys;

import com.capacitaciones.continuas.Modelos.Primary.Notas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotasRepository extends JpaRepository<Notas, Integer> {
    List<Notas> findByPartipantesMatriculadosInscritoCursoIdCurso(Integer idCurso);

    List<Notas> findByPartipantesMatriculadosIdParticipanteMatriculado(Integer idParticipantesFinales);

    //public boolean

}
