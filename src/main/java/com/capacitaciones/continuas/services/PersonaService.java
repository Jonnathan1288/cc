package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.Persona;

public interface PersonaService extends GenericService<Persona, Integer>{
    public Boolean existsByIdentificacion(String identificasion);

}
