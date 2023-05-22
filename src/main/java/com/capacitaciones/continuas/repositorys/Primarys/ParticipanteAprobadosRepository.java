package com.capacitaciones.continuas.repositorys.Primarys;

import com.capacitaciones.continuas.Modelos.Primary.ParticipantesAprobados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipanteAprobadosRepository extends JpaRepository<ParticipantesAprobados, Integer> {
    public List<ParticipantesAprobados> findByPartipantesMatriculadosInscritoCursoIdCurso(Integer idCurso);
    public boolean existsByPartipantesMatriculadosInscritoCursoIdCurso(Integer idCurso);

    //Por el momento este metodo no se va poner en uso pero queda vijente para otro uso..
    @Query("SELECT p FROM ParticipantesAprobados p INNER JOIN p.partipantesMatriculados pm INNER JOIN pm.inscrito ins INNER JOIN ins.curso cu INNER JOIN ins.usuario u INNER JOIN u.persona per WHERE cu.idCurso = :idCurso AND per.identificacion = :ci")
    public ParticipantesAprobados findByCursoAndUsuario(@Param("idCurso") Integer idCurso, @Param("ci") String ci);

}

