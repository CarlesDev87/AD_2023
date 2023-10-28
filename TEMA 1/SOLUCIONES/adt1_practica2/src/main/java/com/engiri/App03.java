package com.engiri;


import java.io.*;

public class App03 {
    public static void main(String[] args) {

        File origen = new File("./src/main/resources/ejercicio3.txt");
        FileReader fr = null;

        int contador = 0;
        int palabras = 0;

        try {
            // Origen
            fr = new FileReader(origen);

            int caracter = fr.read();

            if(caracter != -1)
                palabras++;

            while (caracter != -1) {
                char c = (char) caracter;
                if (esVocal(c)) {
                    contador = contador + 1;
                }else{
                    if(esEspacio(c)){
                        palabras = palabras + 1;
                    }
                }
                caracter = fr.read();
            }

            System.out.println("Número de vocales: " + contador + " - Número de palabras: " + palabras);
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado.");
        } catch (IOException ex) {
            System.out.println("Error de I/O.");
        } finally {
            try {
                fr.close();
            } catch (Exception e) {
                System.out.println("Error en el finally.");
            }

        }

    } // Fin del main

    public static boolean esVocal(char c) {
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }

    public static boolean esEspacio(char c) {
        switch (c) {
            case ' ':
                return true;
            default:
                return false;
        }
    }
}

