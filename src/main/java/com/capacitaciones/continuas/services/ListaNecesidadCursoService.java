package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.ListaNecesidadCurso;

import java.util.List;

public interface ListaNecesidadCursoService extends  GenericService<ListaNecesidadCurso, Integer>{
    public List<ListaNecesidadCurso> findByNecesidadCurso_IdNecesidadCurso(Integer idNecesidad);

}
