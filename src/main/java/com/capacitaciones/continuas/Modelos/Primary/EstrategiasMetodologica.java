package com.capacitaciones.continuas.Modelos.Primary;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "estrategias_metodologicas")
public class EstrategiasMetodologica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estrategia_metodologica")
    private Integer idEstrategiaMetodologica;

    @Column(name = "nombre_estrategia_metodologica", length = 1000)
    private String nombreEstrategiaMetodologica;

    @Column(name = "finalidad_estrategia_metodologica", length = 1000)
    private String finalidadEstrategiaMetodologica;

    @Column(name = "estado_estrategia_metodologica_activo", columnDefinition = "BOOLEAN")
    private Boolean estadoEstrategiaMetodologicaActivo;

    @ManyToOne
    @JoinColumn(name="id_silabo",referencedColumnName ="id_silabo")
    private Silabo silabo;

}
