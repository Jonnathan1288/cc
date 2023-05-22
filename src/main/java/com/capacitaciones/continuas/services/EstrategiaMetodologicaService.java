package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.EstrategiasMetodologica;

import java.util.List;

public interface EstrategiaMetodologicaService extends  GenericService<EstrategiasMetodologica, Integer>{

    List<EstrategiasMetodologica> findBySilaboIdSilabo(Integer idSilabo);
}
