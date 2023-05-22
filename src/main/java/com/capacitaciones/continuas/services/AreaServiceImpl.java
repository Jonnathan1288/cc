package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.Area;
import com.capacitaciones.continuas.repositorys.Primarys.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class AreaServiceImpl extends GenericServiceImpl<Area, Integer> implements AreaService{
    @Autowired
    private AreaRepository areaRepository;
    @Override
    public CrudRepository<Area, Integer> getDao() {
        return areaRepository;
    }
}
