package com.capacitaciones.continuas.repositorys.Primarys;


import com.capacitaciones.continuas.Modelos.Primary.ResultadoAprendizajeSilabo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultadosAprendizajeSilaboRepository extends JpaRepository<ResultadoAprendizajeSilabo, Integer> {

    List<ResultadoAprendizajeSilabo> findBySilaboIdSilabo(Integer idSilabo);

}
