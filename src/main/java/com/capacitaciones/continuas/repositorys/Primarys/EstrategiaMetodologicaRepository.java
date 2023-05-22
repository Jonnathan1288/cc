package com.capacitaciones.continuas.repositorys.Primarys;

import com.capacitaciones.continuas.Modelos.Primary.EstrategiasMetodologica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstrategiaMetodologicaRepository extends JpaRepository<EstrategiasMetodologica, Integer> {

    List<EstrategiasMetodologica> findBySilaboIdSilabo(Integer idSilabo);

}
