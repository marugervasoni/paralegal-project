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
@Table(name="Recordatorios")
public class Recordatorio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate vencimiento;

    private String descripcion;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_expediente", referencedColumnName = "id", nullable = false)
    private Expediente expediente;
}