package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.Modelos.Primary.Especialidad;

import java.util.List;

public interface EspecialidadService extends  GenericService<Especialidad, Integer>{
    public List<Especialidad> findByAreaIdArea(Integer idArea);
}
