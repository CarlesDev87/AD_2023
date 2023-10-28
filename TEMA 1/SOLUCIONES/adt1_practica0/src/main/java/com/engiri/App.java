package com.engiri;

public class App {
    public static void main(String[] args) {

        System.out.println("PRÁCTICA 0 CON ARRAYLIST....");
        Noticia n1 = new Noticia(20220131, 1133, "Primera noticia");
        Noticia n2 = new Noticia(20231131, 2055, "Segunda noticia");
        Noticia n3 = new Noticia(20220303, 1211, "Tercera noticia");
        Noticia n4 = new Noticia(20190301, 1545, "Ultima noticia");

        Periodico p1 = new Periodico();

        p1.insertar(n1);
        p1.insertar(n2);
        p1.insertar(n3);
        p1.insertar(n4);

        // Lecturas de noticias
        n1.incLecturas();
        n1.incLecturas();
        n3.incLecturas();
        n3.incLecturas();
        n3.incLecturas();
        n3.incLecturas();
        n3.incLecturas();
        n3.incLecturas();

        p1.mostrar();

        System.out.println("Noticies més populars:");
        p1.masPopulars();

        System.out.println("Després de borrar noticies anteriors a 01/01/2023");
        p1.esborrarAnteriors(1, 1, 2023);
        p1.mostrar();
    }
}