package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.DetalleFichaMatricula;
import com.capacitaciones.continuas.repositorys.Primarys.DetalleFichaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class DetalleFichaServiceImpl extends GenericServiceImpl<DetalleFichaMatricula, Integer> implements DetalleFichaService{
    @Autowired
    private DetalleFichaRepository detalleFichaRepository;
    @Override
    public CrudRepository<DetalleFichaMatricula, Integer> getDao() {
        return detalleFichaRepository;
    }

    @Override
    public DetalleFichaMatricula findByUsuarioIdUsuario(Integer idUsuario) {
        return detalleFichaRepository.findByUsuarioIdUsuario(idUsuario);
    }
}
