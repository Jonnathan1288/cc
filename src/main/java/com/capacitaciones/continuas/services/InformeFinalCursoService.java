package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.InformeFinalCurso;

public interface InformeFinalCursoService  extends GenericService<InformeFinalCurso, Integer>{
    public InformeFinalCurso findByCursoIdCurso(Integer idCurso);
}
