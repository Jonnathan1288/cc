package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.Silabo;

public interface SilaboService extends GenericService<Silabo,Integer>{

    Boolean findByCursoIdCurso(Integer idCurso);


    Silabo SilabofindByCursoIdCurso(Integer idCurso);

}
