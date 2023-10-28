package com.carlamo;

public class GestionArchivos {
    private String rutaTrabajo;
    private String nuevaCarpeta;
    private String nombreArchivo;

    public GestionArchivos() {
        this.rutaTrabajo = "c:/";
        this.nuevaCarpeta = "";
        this.nombreArchivo = "";
    }


    public String getRutaTrabajo() {
        return rutaTrabajo;
    }

    public void setRutaTrabajo(String rutaTrabajo) {
        this.rutaTrabajo = rutaTrabajo;
    }

    public String getNuevaCarpeta() {
        return nuevaCarpeta;
    }

    public void setNuevaCarpeta(String nuevaCarpeta) {
        this.nuevaCarpeta = nuevaCarpeta;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void listarRutaTrabajo() {

    }

    public void informacionDetallada() {

    }

    public void crearCarpeta() {

    }

    public void crearFichero() {

    }

    public void eliminarFichero() {

    }
}
