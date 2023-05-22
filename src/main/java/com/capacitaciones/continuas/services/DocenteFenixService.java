package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.Modelos.Secondary.DocenteFenix;

public interface DocenteFenixService extends GenericService<DocenteFenix,Integer>{
    public DocenteFenix findByAndIdentificacion(String identificasion);
}
