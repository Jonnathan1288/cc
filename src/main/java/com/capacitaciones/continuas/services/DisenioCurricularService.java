package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.Modelos.Primary.DisenioCurricular;

public interface DisenioCurricularService extends  GenericService<DisenioCurricular, Integer>{
    Boolean findBySilaboIdSilabo(Integer idSilabo);


    DisenioCurricular DisenioCurricularfindBySilaboIdSilabo(Integer idSilabo);


    public DisenioCurricular findBySilaboCursoIdCurso(Integer idCurso);
}
