package org.example.proyecto_nomadas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Lugar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    //Tipo de lugar donde se esté, restaurante, parque, hotel, ...
    private String tipo;

    private String direccion;

    //Descripcion del lugar ?
    //private String descripcion;

    //Horario de apertura ?
    //private String horario;

    //Valoracion del lugar ?
    //private Integer valoracion;

    private String informacionContacto;
}
