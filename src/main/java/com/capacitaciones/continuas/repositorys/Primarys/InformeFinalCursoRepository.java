package com.capacitaciones.continuas.repositorys.Primarys;

import com.capacitaciones.continuas.Modelos.Primary.InformeFinalCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformeFinalCursoRepository extends JpaRepository<InformeFinalCurso, Integer> {
    public InformeFinalCurso findByCursoIdCurso(Integer idCurso);
}

