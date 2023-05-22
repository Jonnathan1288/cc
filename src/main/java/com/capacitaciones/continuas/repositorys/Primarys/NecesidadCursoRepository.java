package com.capacitaciones.continuas.repositorys.Primarys;

import com.capacitaciones.continuas.Modelos.Primary.NecesidadCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NecesidadCursoRepository extends JpaRepository<NecesidadCurso, Integer> {
    public NecesidadCurso findByCursoIdCurso(Integer idCurso);
}

