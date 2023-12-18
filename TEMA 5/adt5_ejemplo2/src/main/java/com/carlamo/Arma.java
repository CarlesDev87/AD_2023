package com.carlamo;

import jakarta.persistence.*;

@Entity
@Table(name = "armas")
public class Arma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_arma")
    private int idArma;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "dano")
    private int dano;

    @OneToOne(mappedBy = "arma")
    private Personaje personaje;

    public Arma() {
    }

    public Arma(String nombre, String descripcion, int dano) {
        super();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.dano = dano;
    }

    public Arma(int idArma, String nombre, String descripcion, int dano) {
        super();
        this.idArma = idArma;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.dano = dano;
    }

    public int getIdArma() {
        return idArma;
    }

    public void setIdArma(int idArma) {
        this.idArma = idArma;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public Personaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }


}

