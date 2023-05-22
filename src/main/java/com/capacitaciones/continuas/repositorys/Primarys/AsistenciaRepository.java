package com.capacitaciones.continuas.repositorys.Primarys;

import com.capacitaciones.continuas.Modelos.Primary.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AsistenciaRepository extends JpaRepository<Asistencia, Integer> {
    //public Boolean existsByFechaAsistencia(LocalDate fecha); //

    public Boolean existsByPartipantesMatriculadosInscritoCursoIdCursoAndFechaAsistencia(Integer idCurso,LocalDate fecha);

    public List<Asistencia> findByPartipantesMatriculadosInscritoCursoIdCursoAndFechaAsistencia(Integer idCurso, LocalDate fecha);


    //public List<PartipantesMatriculados> findByInscritoCursoIdCurso(Integer idCurso);
}
