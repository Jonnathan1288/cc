package com.capacitaciones.continuas.services;

import com.capacitaciones.continuas.Modelos.Primary.ModalidadCurso;
import com.capacitaciones.continuas.repositorys.Primarys.ModalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ModalidadCursoServiceImpl extends GenericServiceImpl<ModalidadCurso, Integer> implements ModalidadCursoService {

    @Autowired
    private ModalidadRepository modalidadRepository;

    @Override
    public CrudRepository<ModalidadCurso, Integer> getDao() {
        return modalidadRepository;
    }
}
