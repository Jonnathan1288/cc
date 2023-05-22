package com.capacitaciones.continuas.Modelos.Primary;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "lista_necesidad_cursos")
public class ListaNecesidadCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lista_necesidad_cursos")
    private Integer idListaNecesidadCursos;

    @Column(name = "detalle_nececidad_curso", length = 1500)
    private String detalleNececidadCurso;

    @Column(name = "estado_detalle_necesidad", columnDefinition = "BOOLEAN")
    private Boolean estadoDetalleNecesidad;

    @ManyToOne
    @JoinColumn(name="id_necesidad_curso",referencedColumnName ="id_necesidad_curso")
    private NecesidadCurso necesidadCurso;
    
}
