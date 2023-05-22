package com.capacitaciones.continuas.Modelos.Primary;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "asistencias")
public class Asistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asistencia")
    private Integer idAsistencia;

    @Column(name = "fecha_asistencia")
    private LocalDate fechaAsistencia;

    @Column(name = "estado_asistencia", columnDefinition = "BOOLEAN") // Para contavilizar el numero de asistencias por día boolean true: asiste; false:Falta
    private Boolean estadoAsistencia;

    @Column(name = "observacion_asistencia", length = 1000)
    private String observacionAsistencia;

    //Viene la llave idParticipanteMatriculado
    @ManyToOne
    @JoinColumn(name="id_participante_matriculado",referencedColumnName ="id_participante_matriculado")
    private PartipantesMatriculados partipantesMatriculados;

}
