package com.capacitaciones.continuas.repositorys.Primarys;


import com.capacitaciones.continuas.Modelos.Primary.ContenidoSilabo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContenidoSilaboRepository extends JpaRepository<ContenidoSilabo, Integer> {

    List<ContenidoSilabo> findBySilaboIdSilabo(Integer idSilabo);

}
