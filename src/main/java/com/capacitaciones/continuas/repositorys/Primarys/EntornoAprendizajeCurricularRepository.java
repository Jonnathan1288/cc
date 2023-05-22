package com.capacitaciones.continuas.repositorys.Primarys;

import com.capacitaciones.continuas.Modelos.Primary.EntornoAprendizajeCurricular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntornoAprendizajeCurricularRepository extends JpaRepository<EntornoAprendizajeCurricular, Integer> {
    List<EntornoAprendizajeCurricular> findByDisenioCurricularIdDisenioCurricular(Integer idCDisenioCurricular);

}
