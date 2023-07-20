package com.api.paralegal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Audiencias")
public class Audiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate fecha;

    private String infoAdicionalAud;

    @ManyToOne
    @JoinColumn(name="id_expediente", nullable = false , referencedColumnName = "id")
    private Expediente expediente;
}
