package com.capacitaciones.continuas.repositorys.Secondary;

import com.capacitaciones.continuas.Modelos.Secondary.DocenteFenix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocenteFenixRepository extends JpaRepository<DocenteFenix,Integer> {
    public DocenteFenix findByAndIdentificacion(String identificasion);
}
