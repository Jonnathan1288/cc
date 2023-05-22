package com.capacitaciones.continuas.Modelos.Primary;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "notas")
public class Notas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nota")
    private Integer idNota;

    @Column(name = "parcial")
    private Integer parcial;

    @Column(name = "examen_final")
    private Integer examenFinal;

    @Column(name = "fecha_nota")
    private LocalDate fechaNota;

    @Column(name = "observacion", length = 1500)
    private String observacion;

    // se relacioina con el estudiante matriculado
    @ManyToOne
    @JoinColumn(name="id_participante_matriculado",referencedColumnName ="id_participante_matriculado")
    private PartipantesMatriculados partipantesMatriculados;


}
