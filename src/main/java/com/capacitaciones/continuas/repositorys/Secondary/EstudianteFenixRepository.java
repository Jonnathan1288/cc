package com.capacitaciones.continuas.repositorys.Secondary;

import com.capacitaciones.continuas.Modelos.Secondary.EstudianteFenix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteFenixRepository extends JpaRepository<EstudianteFenix,Integer> {
    public EstudianteFenix findByAndIdentificacion(String identificasion);
}
