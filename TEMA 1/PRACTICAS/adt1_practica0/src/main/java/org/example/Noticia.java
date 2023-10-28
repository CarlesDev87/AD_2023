package org.example;

public class Noticia {

    // ATRIBUTOS
    private int hora;
    private String texto;
    private int numLecturas;
    private int fecha;

    //CONSTRUCTOR

    public Noticia(int fecha, int hora, String texto) {
        this.fecha = fecha;
        this.hora = hora;
        this.texto = texto;

    }

    // METODOS

    public int getData() {
        return fecha;
    }

    public int getLecturas() {
       return numLecturas;
    }

    public void incLecturas() {
        numLecturas++;
    }

    public String toString() {
        String s = "";
        s+=fecha%100 + "/" + (fecha/100)%100 + "/" + (fecha/1000) + " - ";
        s+=(hora/100) + ":" + (hora%100) + "\n";
        s+=texto + "\n";
        s+="Leída " + numLecturas + " veces\n";

        return s;

    }



    public boolean igualData(int d, int m, int a) {
        return false;
    }

    // GETTER & SETTER
    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public String getNoticia() {
        return texto;
    }

    public void setNoticia(String texto) {
        this.texto = texto;
    }

    public int getNumLecturas() {
        return numLecturas;
    }

    public void setNumLecturas(int numLecturas) {
        this.numLecturas = numLecturas;
    }




}
