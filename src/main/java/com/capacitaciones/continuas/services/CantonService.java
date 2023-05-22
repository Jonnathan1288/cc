package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.Canton;
import com.capacitaciones.continuas.Modelos.Primary.Parroquia;

import java.util.List;

public interface CantonService extends  GenericService<Canton, Integer>{
    public List<Canton> findByProvinciaIdProvincia(Integer idProvincia);
}
