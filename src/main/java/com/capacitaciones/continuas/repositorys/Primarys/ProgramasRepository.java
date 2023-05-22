package com.capacitaciones.continuas.repositorys.Primarys;


import com.capacitaciones.continuas.Modelos.Primary.Programas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramasRepository extends JpaRepository<Programas , Integer> {
}
