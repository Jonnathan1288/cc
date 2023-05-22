package com.capacitaciones.continuas.Modelos.Primary;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "pruebaPdfs")
public class PruebaPdf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpruebaPdfs")
    private Integer idpruebaPdfs;

    @Column(name = "nombre ")
    private String nombre;

    @Column(name = "pdf ",  columnDefinition = "LONGBLOB")
    private String pdf;

    @Column(name = "exel ",  columnDefinition = "LONGBLOB")
    private String exel;
}
