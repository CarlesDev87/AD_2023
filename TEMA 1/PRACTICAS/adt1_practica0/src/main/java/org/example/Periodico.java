package org.example;

import java.io.IOException;
import java.util.ArrayList;

public class Periodico {

    private ArrayList<Noticia> noticias = new ArrayList<Noticia>();
    private int numNoticias;

    public Periodico() {
        this.noticias = new ArrayList<>();
        this.numNoticias = getNumNoticias();
    }

    public void insertar(Noticia n) {
        if (numNoticias<10) {
            noticias.add(n);
            numNoticias++;
        } else {
            System.out.println("No caben más noticias");
        }

    }

    public Noticia primeraNoticia (int d, int m, int a) {
        int i = 0;
        while (i < numNoticias && !noticias.get(i).igualData(d,m,a)) {
            i++;
        }
        if (i < numNoticias) {
            return noticias.get(i);
        } else  {
            return null;
        }

    }

    public void masPopulars() {
        if (numNoticias == 0) {
            System.out.println("Sin noticias.");
        } else {
            Noticia mesP = noticias.get(0);
            int indMesP = 0;
            for (int i = 1; i < numNoticias; i++) {
                if (noticias.get(i).getLecturas() > mesP.getLecturas()) {
                    mesP = noticias.get(i);
                    indMesP = i;
                }
            }

            System.out.println(mesP);

            for (int j = indMesP + 1; j < numNoticias; j++) {
                if (noticias.get(j).getLecturas() == mesP.getLecturas()) {
                    System.out.println(noticias.get(j));
                }
            }
        } // Fin del else
    }

    public void esborrarAnteriors(int d, int m, int a) {

        int fecha = a * 10000 + m * 100 + d;

        for (int i = 0; i < numNoticias; i++) {
            if (noticias.get(i).getFecha() < fecha) {
                noticias.remove(i);
                numNoticias--;
            }
        }
    }

    public void mostrar() {
        for (Noticia nn : noticias) {
            System.out.println(nn);
        }
    }

    public ArrayList<Noticia> getNoticias() {
        return noticias;
    }

    public void setNoticias(ArrayList<Noticia> noticias) {
        this.noticias = noticias;
    }

    public int getNumNoticias() {
        return numNoticias;
    }

    public void setNumNoticias(int numNoticias) {
        this.numNoticias = numNoticias;
    }


}
