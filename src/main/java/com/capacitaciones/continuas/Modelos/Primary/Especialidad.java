package com.capacitaciones.continuas.Modelos.Primary;

import com.capacitaciones.continuas.Modelos.Primary.Area;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Setter
@Getter
@Entity
@Table(name = "especialidades")
public class Especialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_especialidad")
    private Integer idEspecialidad;

    @Column(name = "codigo_especialidad")
    private String codigoEspecialidad;

    @Column(name = "nombre_especialidad", length = 1000)
    private String nombreEspecialidad;

    @Column(name = "estado_especialidad_activo", columnDefinition = "BOOLEAN")
    private Boolean estadoEspecialidadActivo;

    // RELACION
    @ManyToOne
    @JoinColumn(name="id_area",referencedColumnName ="id_area")
    private Area area;

}
