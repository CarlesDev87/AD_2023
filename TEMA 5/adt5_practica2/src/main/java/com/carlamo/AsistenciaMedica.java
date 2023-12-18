package com.carlamo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name ="asistencia_medica")
public class AsistenciaMedica {

    @Id
    @Column
    private int idAsistenciaMedica;

    @Column(name="descripcion")
    private String breveDescripcion;

    @Column(name="lugar")
    private String lugar;

    @Column
    private Double importe;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="id_seguro")
    private Seguro seguro;
}
