package com.capacitaciones.continuas.Modelos.Primary;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "participantesaprobados")
public class ParticipantesAprobados { //estado en  vigencia

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_participantes_aprobados")
    private Integer idParticipantesAprobados;

    @Column(name = "codigo_senecyt")
    private String codigoSenecyt;

    @Column(name = "certificado_participante", columnDefinition = "LONGBLOB")
    private String certificadoParticipante;

    @Column(name = "certificado_firmado", columnDefinition = "BOOLEAN")
    private Boolean certificadoFirmado;

    // Se relaciona con participantes matriculado
//viene la llave de id curso
    @ManyToOne
    @JoinColumn(name="id_participante_matriculado", referencedColumnName ="id_participante_matriculado")
    private PartipantesMatriculados partipantesMatriculados;
}
