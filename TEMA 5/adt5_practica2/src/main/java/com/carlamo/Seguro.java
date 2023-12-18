package com.carlamo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Seguro {

    public Seguro(int idSeguro, String nif, String nombre, String ape1, String ape2, int edad, int numHijos, LocalDate fechaCreacion) {
        this.idSeguro = idSeguro;
        this.nif = nif;
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
        this.edad = edad;
        this.numHijos = numHijos;
        this.fechaCreacion = fechaCreacion;
    }

    @Id
    @Column(name = "id")
    private int idSeguro;

    @Column(name = "nif")
    private String nif;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido1")
    private String ape1;

    @Column(name = "apellido2")
    private String ape2;

    @Column(name = "edad")
    private int edad;

    @Column(name = "numero_hijos")
    private int numHijos;

    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;

    @OneToMany(mappedBy = "seguro", cascade = CascadeType.ALL)
    List<AsistenciaMedica> asistenciasMedicas;


    @Override
    public String toString() {
        return "Seguro{" +
                "idSeguro=" + idSeguro +
                ", nif='" + nif + '\'' +
                ", nombre='" + nombre + '\'' +
                ", ape1='" + ape1 + '\'' +
                ", ape2='" + ape2 + '\'' +
                ", edad=" + edad +
                ", numHijos=" + numHijos +
                ", fechaCreacion=" + fechaCreacion +
                '}';
    }
}
