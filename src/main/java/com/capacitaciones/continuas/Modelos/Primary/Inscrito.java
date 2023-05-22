package com.capacitaciones.continuas.Modelos.Primary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "inscritos")
public class Inscrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inscrito")
    private Integer idInscrito;

    @Column(name = "fecha_inscrito")
    private LocalDate fechaInscrito;

    @Column(name = "estado_inscrito", columnDefinition = "BOOLEAN")
    private Boolean estadoInscrito;

    @Column(name = "estado_inscrito_activo", columnDefinition = "BOOLEAN")
    private Boolean estadoInscritoActivo;

    // SE RELACIONA CON USER Y CURSO

    // RELACIONES
    @ManyToOne
    @JoinColumn(name="id_usuario",referencedColumnName ="id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name="id_curso",referencedColumnName ="id_curso")
    private Curso curso;


    //Falta referenciar, FichaMatricula, ParticipantesAprobados

    @JsonIgnore
    @OneToMany(mappedBy = "inscrito")
    private List<PartipantesMatriculados> partipantesMatriculados;


}
