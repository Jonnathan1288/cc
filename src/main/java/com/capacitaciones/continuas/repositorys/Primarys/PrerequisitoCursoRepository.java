package com.capacitaciones.continuas.repositorys.Primarys;

import com.capacitaciones.continuas.Modelos.Primary.PrerequisitoCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrerequisitoCursoRepository extends JpaRepository<PrerequisitoCurso, Integer> {

    List<PrerequisitoCurso> findByCursoIdCurso(Integer idCurso);
}
