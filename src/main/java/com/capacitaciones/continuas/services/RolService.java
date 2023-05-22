package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.Rol;

public interface RolService extends GenericService<Rol,Integer>{

    Rol findByNombreRol(String nombreRol);
}
