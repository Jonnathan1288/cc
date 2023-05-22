package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.MaterialConvencional;
import com.capacitaciones.continuas.repositorys.Primarys.MaterialConvencionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialConvencionalServiceImpl extends GenericServiceImpl<MaterialConvencional, Integer> implements MaterialConvencionalService {

    @Autowired
    private MaterialConvencionalRepository recursoDidacticoRepository;

    @Override
    public CrudRepository<MaterialConvencional, Integer> getDao() {
        return recursoDidacticoRepository;
    }

    public List<MaterialConvencional> findBySilaboIdSilabo(Integer idSilabo) {
        return recursoDidacticoRepository.findBySilaboIdSilabo(idSilabo);
    }
}
