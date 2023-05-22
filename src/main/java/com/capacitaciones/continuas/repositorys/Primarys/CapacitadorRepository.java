package com.capacitaciones.continuas.repositorys.Primarys;

import com.capacitaciones.continuas.Modelos.Primary.Capacitador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapacitadorRepository extends JpaRepository<Capacitador, Integer> {
    public Capacitador findByUsuarioIdUsuario(Integer idUsuario);

    public Boolean existsByUsuarioIdUsuario(Integer idUsuario);
}

