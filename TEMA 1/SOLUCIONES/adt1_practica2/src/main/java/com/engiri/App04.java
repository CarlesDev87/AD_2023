package com.engiri;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class App04 {
    public static void main(String[] args) {


        FileReader fr1 = null;
        FileReader fr2 = null;
        BufferedReader bf1 = null;
        BufferedReader bf2 = null;
        try {

            fr1 = new FileReader("./src/main/resources/ejercicio4a.txt");
            fr2 = new FileReader("./src/main/resources/ejercicio4b.txt");
            bf1 = new BufferedReader(fr1);
            bf2 = new BufferedReader(fr2);

            String sCadena1, sCadena2;
            boolean iguales = true;

            sCadena1 = bf1.readLine();
            sCadena2 = bf2.readLine();
            while ((sCadena1 != null) && (sCadena2 != null) && iguales) {

                if (!sCadena1.equals(sCadena2)) {
                    iguales = false;
                }

                sCadena1 = bf1.readLine();
                sCadena2 = bf2.readLine();
            }

            if ((iguales) && (sCadena1 == null) && (sCadena2 == null)) {
                System.out.println("Los ficheros son iguales");
            } else {
                System.out.println("Los ficheros son diferentes");
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Error el fichero no existe.");
        } catch (IOException ex) {
            System.out.println("Error de I/O.");
        } finally {
            try {
                if (bf1 != null) {
                    bf1.close();
                }
                if (bf2 != null) {
                    bf2.close();
                }
            } catch (IOException ex) {
                System.out.println("Error en el finally.");
            }
        }
    } // Fin del main
}

