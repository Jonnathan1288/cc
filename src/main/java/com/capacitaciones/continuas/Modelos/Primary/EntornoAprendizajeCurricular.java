package com.capacitaciones.continuas.Modelos.Primary;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "entornoaprendizajescurriculares")
public class EntornoAprendizajeCurricular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entorno_curricular")
    private Integer idEntornoCurricular;

    @Column(name = "instalaciones", length = 1000)
    private String instalaciones;

    @Column(name = "fase_feorica", length = 1200)
    private String faseTeorica;

    @Column(name = "fase_practica", length = 1200)
    private String fasePractica ;


    //NUEVO ATRIBUTO
    @Column(name = "estadoEntornoAprendizaje", columnDefinition = "BOOLEAN")
    private Boolean estadoEntornoAprendizaje;

    // se relaciona con curriculo
    @ManyToOne
    @JoinColumn(name="id_disenio_curricular",referencedColumnName ="id_disenio_curricular")
    private DisenioCurricular disenioCurricular;
}
