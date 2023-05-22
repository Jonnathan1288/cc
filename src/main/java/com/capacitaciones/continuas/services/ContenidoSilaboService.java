package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.ContenidoSilabo;

import java.util.List;

public interface ContenidoSilaboService extends  GenericService<ContenidoSilabo, Integer>{

    List<ContenidoSilabo> findBySilaboIdSilabo(Integer idSilabo);

}
