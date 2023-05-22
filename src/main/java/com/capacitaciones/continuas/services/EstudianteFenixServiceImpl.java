package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.Modelos.Secondary.DocenteFenix;
import com.capacitaciones.continuas.Modelos.Secondary.EstudianteFenix;
import com.capacitaciones.continuas.repositorys.Secondary.DocenteFenixRepository;
import com.capacitaciones.continuas.repositorys.Secondary.EstudianteFenixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class EstudianteFenixServiceImpl extends GenericServiceImpl<EstudianteFenix, Integer> implements EstudianteFenixService {

    @Autowired
    private EstudianteFenixRepository estudianteFenixRepository;

    @Override
    public CrudRepository<EstudianteFenix, Integer> getDao() {
        return estudianteFenixRepository;
    }

    @Override
    public EstudianteFenix findByAndIdentificacion(String identificasion) {
        return estudianteFenixRepository.findByAndIdentificacion(identificasion);
    }
}

