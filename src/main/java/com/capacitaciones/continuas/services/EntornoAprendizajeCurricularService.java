package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.Modelos.Primary.EntornoAprendizajeCurricular;

import java.util.List;

public interface EntornoAprendizajeCurricularService extends  GenericService<EntornoAprendizajeCurricular, Integer>{
    List<EntornoAprendizajeCurricular> findByDisenioCurricularIdDisenioCurricular(Integer idCDisenioCurricular);
}
