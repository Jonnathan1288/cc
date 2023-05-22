package com.capacitaciones.continuas.repositorys.Primarys;

import com.capacitaciones.continuas.Modelos.Primary.MaterialConvencional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialConvencionalRepository extends JpaRepository<MaterialConvencional, Integer> {

    List<MaterialConvencional> findBySilaboIdSilabo(Integer idSilabo);

}
