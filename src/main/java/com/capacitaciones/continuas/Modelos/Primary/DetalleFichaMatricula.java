package com.capacitaciones.continuas.Modelos.Primary;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Setter
@Getter
@Entity
@Table(name = "detallefichamatriculas")
public class DetalleFichaMatricula { // esta entidad esta en vigencia.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_ficha_matricula")
    private Integer idDetalleFichaMatricula;

    @Column(name = "pregunta1", length = 1000)
    private String pregunta1;

    @Column(name = "pregunta2", length = 1000)
    private String pregunta2;

    @Column(name = "pregunta3", length = 1000)
    private String pregunta3;

    @Column(name = "pregunta4", length = 1000)
    private String pregunta4;

    @Column(name = "pregunta5", length = 1000)
    private String pregunta5;

    @Column(name = "pregunta6", length = 1000)
    private String pregunta6;

    @Column(name = "pregunta7", length = 1000)
    private String pregunta7;

    @Column(name = "pregunta8", length = 1000)
    private String pregunta8;

    @Column(name = "pregunta9", length = 1000)
    private String pregunta9;

    // RELACION NUEVA
    @ManyToOne
    @JoinColumn(name="id_usuario",referencedColumnName ="id_usuario")
    private Usuario usuario;
}
