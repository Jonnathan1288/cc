package com.capacitaciones.continuas.Modelos.Primary;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "contenidosilabos")
public class ContenidoSilabo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contenido_silabo")
    private Integer idContenidoSilabo;

    @Column(name = "tema_contenido", length = 1000)
    private String temaContenido;

    @Column(name = "dia_contenido")
    private Integer diaContenido;

    @Column(name = "horas_clase_contenido")
    private Integer horasClaseContenido;

    @Column(name = "actividades_docencia")
    private String actividadesDocencia;

    @Column(name = "horas_practicas")
    private Integer horasPracticas;

    @Column(name = "actividades_practicas", length = 1200)
    private String actividadesPracticas;

    @Column(name = "horas_autonomas")
    private Integer horasAutonomas;

    @Column(name = "actividades_autonomas", length = 1200)
    private String actividadesAutonomas;

    @Column(name = "observaciones", length = 1000)
    private String observaciones;

    @Column(name = "estado_contenido", columnDefinition = "BOOLEAN")
    private Boolean estadoContenido;

    // Se relaciona con Silabo


    @ManyToOne
    @JoinColumn(name="id_silabo",referencedColumnName ="id_silabo")
    private Silabo silabo;

}
