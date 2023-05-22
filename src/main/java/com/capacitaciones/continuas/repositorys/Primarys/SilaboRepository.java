package com.capacitaciones.continuas.repositorys.Primarys;

import com.capacitaciones.continuas.Modelos.Primary.Silabo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SilaboRepository extends JpaRepository<Silabo, Integer> {
    Silabo findByCursoIdCurso(Integer idCurso);
}
