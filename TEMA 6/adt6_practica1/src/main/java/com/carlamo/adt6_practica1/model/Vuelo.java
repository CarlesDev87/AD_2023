package com.carlamo.adt6_practica1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column
    private String origen;
    @Column
    private String destino;
    @Column
    private Double precio;
    @Column
    private int numeroEscalas;
    @Column
    private String compañia;



}
