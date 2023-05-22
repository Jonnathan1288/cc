package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.Capacitador;

public interface CapacitadorService extends  GenericService<Capacitador, Integer>{
    public Capacitador findByUsuarioIdUsuario(Integer idUsuario);

    public Boolean existsByUsuarioIdUsuario(Integer idUsuario);
}
