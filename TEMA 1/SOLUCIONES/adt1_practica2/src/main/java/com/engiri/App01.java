package com.engiri;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App01 {

    public static void menu() {
        System.out.println("\n");
        System.out.println("================================================");
        System.out.println("===================== MENÚ =====================");
        System.out.println("1.- Leer desde fichero.");
        System.out.println("2.- Escribir en el fichero.");
        System.out.println("3.- Salir.");
        System.out.println("================================================");
        System.out.println("================================================");
        System.out.print("Opción? ");

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {

            menu();
            String opcion = in.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("1.- Dame el nombre del fichero que quieres leer: ");
                    String ruta = in.nextLine();

                    try {
                        FileReader archivo = new FileReader("./src/main/resources/" + ruta);
                        BufferedReader br = new BufferedReader(archivo);
                        String cadena;

                        while ((cadena = br.readLine()) != null) {
                            System.out.println(cadena + " ");
                        }

                        archivo.close();

                    } catch (IOException err) {
                        System.out.println("Error: " + err.toString());
                    }

                case "2":
                    System.out.print("2.- Dame la nombre del fichero que quieres escribir: ");
                    String destino = in.nextLine();

                    try {
                        FileWriter f1 = new FileWriter("./src/main/resources/" + destino, true);

                        System.out.println("\nIntroduce una frase para el fichero: ");
                        String mensaje2 = in.nextLine();

                        f1.write(mensaje2 + " ");

                        f1.close();

                    } catch (IOException err) {
                        System.out.println("Error: " + err.toString());
                    }
                    break;

                case "3":
                    System.out.println("Has salido de la aplicación.");
                    salir = true;
                    break;
            } // fin del switch

        } // fin del while

        try {

            in.close();

        } catch (Exception e) {
            System.out.println("Error en el finally.");
        }

    } // Fin del main

}

