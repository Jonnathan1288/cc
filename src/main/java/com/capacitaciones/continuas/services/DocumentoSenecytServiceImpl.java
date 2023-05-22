package com.capacitaciones.continuas.services;


import com.capacitaciones.continuas.Modelos.Primary.DocumentoSenecyt;
import com.capacitaciones.continuas.Modelos.Secondary.DocenteFenix;
import com.capacitaciones.continuas.repositorys.Primarys.DocumentoSenecytRepository;
import com.capacitaciones.continuas.repositorys.Secondary.DocenteFenixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class DocumentoSenecytServiceImpl extends GenericServiceImpl<DocumentoSenecyt, Integer> implements DocumentoSenecytService {

    @Autowired
    private DocumentoSenecytRepository documentoSenecytRepository;

    @Override
    public CrudRepository<DocumentoSenecyt, Integer> getDao() {
        return documentoSenecytRepository;
    }


}

